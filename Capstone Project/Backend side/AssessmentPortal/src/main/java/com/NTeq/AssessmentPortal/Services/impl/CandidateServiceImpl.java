package com.NTeq.AssessmentPortal.Services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.NTeq.AssessmentPortal.Dto.CandidateDto;
import com.NTeq.AssessmentPortal.Entity.Candidate;
import com.NTeq.AssessmentPortal.Exceptions.DuplicateEmail;
import com.NTeq.AssessmentPortal.Exceptions.FieldsRequiredException;
import com.NTeq.AssessmentPortal.Exceptions.InvalidEmailDomainException;
import com.NTeq.AssessmentPortal.Exceptions.ResourceNotFound;
import com.NTeq.AssessmentPortal.Exceptions.WrongCredentialException;
import com.NTeq.AssessmentPortal.Repositories.CandidateRepository;
import com.NTeq.AssessmentPortal.Services.CandidateService;

/**
 * Service implementation for managing candidate-related operations.
 */
@Service
public class CandidateServiceImpl implements CandidateService {
    /**
     * Repository for candidate data. Injected by Spring using @Autowired.
     */
    @Autowired
    private CandidateRepository candidateRepository;
    /**
     * Password encoder utility. Injected by Spring using @Autowired.
     */
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

   /**
    * Object mapper for DTO-entity mapping.Injected by Spring using @Autowired.
    */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Adds a new candidate to the system.
     * @param cdDto The DTO containing candidate details.
     * @return A message indicating the result of the operation.
     * @throws FieldsRequiredException If required fields are missing.
     * @throws DuplicateEmail If the provided email already exists.
     */
    @Override
    public final String addCandidate(final CandidateDto cdDto) {
        Candidate cd = this.dtoToCandidate(cdDto);
        if (cd.getFirstName() == null || cd.getLastName() == null
                || cd.getEmail() == null || cd.getPassword() == null) {
            throw new FieldsRequiredException("All fields are required");
        } else {
            if (!cd.getEmail().endsWith("@nucleusTeq.com")) {
                throw new InvalidEmailDomainException(
                        "Email domain should be @nucleusTeq.com");
            }
            Optional<Candidate> existingCdByEmail = candidateRepository
                    .findByEmail(cd.getEmail());
            if (existingCdByEmail.isPresent()) {
                throw new DuplicateEmail("Email already exits");
            }
            Candidate newCd = new Candidate(0, cd.getFirstName(),
                    cd.getLastName(), cd.getEmail(),
                    this.passwordEncoder.encode(cd.getPassword()), "user",
                    cd.getPhoneNumber());
            try {
                candidateRepository.save(newCd);
            } catch (Exception e) {
                throw e;
            }
            return newCd.getEmail() + " registered successfully";
        }
    }

    /**
     * Retrieves a list of all candidates.
     * @return A list of candidate DTOs.
     */
    @Override
    public final List<CandidateDto> getAllCandidate() {
        List<Candidate> cds = this.candidateRepository.findAll();
        List<CandidateDto> cdDtos = cds.stream()
                .map(candidate -> this.candidateToDto(candidate))
                .collect(Collectors.toList());
        return cdDtos;
    }

    /**
     * Logs in a candidate using provided credentials.
     * @param inCandidateDto The DTO containing candidate login credentials.
     * @return A map with login response status and message.
     * @throws WrongCredentialException If login credentials are incorrect.
     * @throws ResourceNotFound         If the user does not exist.
     */
    @Override
    public final Map<String, String> loginCandidate(final
        CandidateDto inCandidateDto) {
        Candidate inCandidate = this.dtoToCandidate(inCandidateDto);
        Map<String, String> response = new HashMap<>();
        Candidate foundCandidate = candidateRepository
                .getByEmail(inCandidate.getEmail());

        if (foundCandidate != null) {
            String password = inCandidate.getPassword();
            String encodedPassword = foundCandidate.getPassword();

            Boolean isCorrect = passwordEncoder.matches(password,
                    encodedPassword);

            if (isCorrect) {
                Optional<Candidate> candidateRegistration = candidateRepository
                        .findByEmailAndPassword(inCandidate.getEmail(),
                                encodedPassword);

                if (candidateRegistration.isPresent()) {
                    response.put("message", "Login Successfully");
                    response.put("status", "true");
                    response.put("email", foundCandidate.getEmail());
                    response.put("userName", foundCandidate.getFirstName()
                            + " " + foundCandidate.getLastName());
                    response.put("role", foundCandidate.getUserRole());
                } else {
                    throw new WrongCredentialException(
                            "Login Failed!! Wrong Credentials");
                }
            } else {
                throw new WrongCredentialException(
                        "Login Failed!! Wrong Credentials");
            }
        } else {
            throw new ResourceNotFound("User doesn't exits");

        }
        return response;
    }

    /**
     * Converts a Candidate entity to its corresponding DTO.
     * @param cd The Candidate entity.
     * @return The corresponding CandidateDto.
     */
    public final CandidateDto candidateToDto(final Candidate cd) {
        CandidateDto cdDto = modelMapper.map(cd, CandidateDto.class);
        return cdDto;
    }

    /**
     * Converts a CandidateDto to its corresponding entity.
     * @param cdDto The CandidateDto.
     * @return The corresponding Candidate entity.
     */
    public final Candidate dtoToCandidate(final CandidateDto cdDto) {
        Candidate cd = this.modelMapper.map(cdDto, Candidate.class);
        return cd;
    }
}
