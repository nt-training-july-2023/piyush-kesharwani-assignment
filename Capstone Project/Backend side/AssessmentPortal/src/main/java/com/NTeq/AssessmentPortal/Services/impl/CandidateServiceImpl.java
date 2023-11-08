package com.NTeq.AssessmentPortal.Services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.NTeq.AssessmentPortal.Dto.CandidateDto;
import com.NTeq.AssessmentPortal.Dto.LoginRequestDto;
import com.NTeq.AssessmentPortal.Entity.Candidate;
import com.NTeq.AssessmentPortal.Exceptions.DuplicateEmail;
import com.NTeq.AssessmentPortal.Exceptions.ResourceNotFound;
import com.NTeq.AssessmentPortal.Exceptions.WrongCredentialException;
import com.NTeq.AssessmentPortal.Repositories.CandidateRepository;
import com.NTeq.AssessmentPortal.Response.Message;
import com.NTeq.AssessmentPortal.Response.SuccessResponse;
import com.NTeq.AssessmentPortal.Services.CandidateService;

/**
 * Service implementation for managing candidate-related operations.
 */
@Service
public class CandidateServiceImpl implements CandidateService {
    /**
     * This class represents a logger for the CandidateServiceImpl.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(CategoryServiceImpl.class);
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
     * @param candidateDto The DTO containing candidate details.
     * @return A message indicating the result of the operation.
     * @throws DuplicateEmail If the provided email already exists.
     */
    @Override
    public final SuccessResponse addCandidate(final CandidateDto candidateDto) {
        Candidate candidate = this.dtoToCandidate(candidateDto);
            Optional<Candidate> existingCdByEmail = candidateRepository
                    .findByEmail(candidate.getEmail());
            if (existingCdByEmail.isPresent()) {
                throw new DuplicateEmail("Email already exits");
            }
            candidate.setUserRole("user");
            candidate.setPassword(
                    passwordEncoder.encode(candidateDto.getPassword()));
                candidateRepository.save(candidate);
               LOGGER.info(Message.REGISTERED_SUCCESSFULLY);
            return new SuccessResponse(HttpStatus.CREATED.value(),
                    Message.REGISTERED_SUCCESSFULLY);
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
     * @param loginRequestDto The DTO containing candidate login credentials.
     * @return A map with login response status and message.
     * @throws WrongCredentialException If login credentials are incorrect.
     * @throws ResourceNotFound         If the user does not exist.
     */
    @Override
    public final Map<String, String> loginCandidate(final
        LoginRequestDto loginRequestDto) {
        Map<String, String> response = new HashMap<>();
        Candidate foundCandidate = candidateRepository
                .getByEmail(loginRequestDto.getEmail());

        if (foundCandidate != null) {
            String password = loginRequestDto.getPassword();
            String encodedPassword = foundCandidate.getPassword();

            Boolean isCorrect = passwordEncoder.matches(password,
                    encodedPassword);

            if (isCorrect) {
                Optional<Candidate> candidateRegistration = candidateRepository
                        .findByEmailAndPassword(loginRequestDto.getEmail(),
                                encodedPassword);

                if (candidateRegistration.isPresent()) {
                    response.put("message", "Login Successfully");
                    response.put("status", "true");
                    response.put("email", foundCandidate.getEmail());
                    response.put("userName", foundCandidate.getFirstName()
                            + " " + foundCandidate.getLastName());
                    response.put("role", foundCandidate.getUserRole());
                } else {
                    LOGGER.error(Message.LOGIN_FAILED);
                    throw new WrongCredentialException(
                            "Login Failed!! Wrong Credentials");
                }
            } else {
                LOGGER.error(Message.LOGIN_FAILED);
                throw new WrongCredentialException(
                        "Login Failed!! Wrong Credentials");
            }
        } else {
            LOGGER.error(Message.USER_NOT_FOUND);
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
