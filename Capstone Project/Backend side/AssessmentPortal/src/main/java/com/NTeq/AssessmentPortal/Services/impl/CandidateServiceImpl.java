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
import com.NTeq.AssessmentPortal.Exceptions.ResourceNotFound;
import com.NTeq.AssessmentPortal.Exceptions.WrongCredentialException;
import com.NTeq.AssessmentPortal.Repositories.CandidateRepository;
import com.NTeq.AssessmentPortal.Services.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String addCandidate(CandidateDto cdDto) {
        Candidate cd = this.dtoToCandidate(cdDto);
        if (cd.getFirstName() == null || cd.getLastName() == null || cd.getEmail() == null
                || cd.getPassword() == null) {
            throw new FieldsRequiredException("All fields are required");
        }

        else {
            Optional<Candidate> existingCdByEmail = candidateRepository.findByEmail(cd.getEmail());
            if (existingCdByEmail.isPresent()) {
                throw new DuplicateEmail("Email already exits");
            }
            Candidate newCd = new Candidate(0, cd.getFirstName(), cd.getLastName(), cd.getEmail(),
                    this.passwordEncoder.encode(cd.getPassword()), "user", cd.getPhoneNumber());
            try {
                candidateRepository.save(newCd);
            } catch (Exception e) {
                throw e;
            }
            return newCd.getEmail() + " registered successfully";

        }
    }

    @Override
    public List<CandidateDto> getAllCandidate() {
        List<Candidate> cds = this.candidateRepository.findAll();
        List<CandidateDto> cdDtos = cds.stream().map(candidate -> this.candidateToDto(candidate))
                .collect(Collectors.toList());
        return cdDtos;
    }

    @Override
    public Map<String, String> loginCandidate(CandidateDto inCandidateDto) {
        Candidate inCandidate = this.dtoToCandidate(inCandidateDto);
        Map<String, String> response = new HashMap<>();
        Candidate foundCandidate = candidateRepository.getByEmail(inCandidate.getEmail());

        if (foundCandidate != null) {
            String password = inCandidate.getPassword();
            String encodedPassword = foundCandidate.getPassword();

            Boolean isCorrect = passwordEncoder.matches(password, encodedPassword);

            if (isCorrect) {
                Optional<Candidate> candidateRegistration = candidateRepository
                        .findByEmailAndPassword(inCandidate.getEmail(), encodedPassword);

                if (candidateRegistration.isPresent()) {
                    response.put("message", "Login Successfully");
                    response.put("status", "true");
                    response.put("role", foundCandidate.getUserRole());
                } else {
                    throw new WrongCredentialException("Login Failed!! Wrong Credentials");
                }
            } else {
                throw new WrongCredentialException("Login Failed!! Password doesnt match");
            }
        } else {
            throw new ResourceNotFound("User doesn't exits");

        }
        return response;
    }

    public CandidateDto candidateToDto(Candidate cd) {
        CandidateDto cdDto = modelMapper.map(cd, CandidateDto.class);
        return cdDto;
    }

    public Candidate dtoToCandidate(CandidateDto cdDto) {
        Candidate cd = this.modelMapper.map(cdDto, Candidate.class);
        return cd;
    }
}
