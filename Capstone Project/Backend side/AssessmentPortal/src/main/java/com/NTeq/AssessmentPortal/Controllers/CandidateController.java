package com.NTeq.AssessmentPortal.Controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NTeq.AssessmentPortal.Dto.CandidateDto;
import com.NTeq.AssessmentPortal.Dto.LoginRequestDto;
import com.NTeq.AssessmentPortal.Services.impl.CandidateServiceImpl;
import jakarta.validation.Valid;

/**
 * Controller class that handles HTTP requests related to candidate operations.
 */
@CrossOrigin
@RestController
@RequestMapping("/candidate")
public class CandidateController {
    /**
     * This class represents a logger for the CandidateController.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(CandidateController.class);
    /**
     * The CandidateService implementation that handles candidate operation.
     * This field is automatically injected by using the @Autowired annotation.
     */
    @Autowired
    private CandidateServiceImpl candidateService;
    /**
     * End point to register a new candidate.
     * @param cdDto The candidate DTO containing registration details.
     * @return A message indicating the registration status.
     */
    @PostMapping(path = "/register")
    public final String saveUser(@Valid final @RequestBody
            CandidateDto cdDto) {
        LOGGER.info("Candidate Method invoke");
        String response = candidateService.addCandidate(cdDto);
        LOGGER.info("Candidate registered succesfully");
        return response;
    }
    /**
     * End point for candidate login.
     * @param loginRequestDto The LoginRequest DTO containing login credentials.
     * @return A map containing login response status and message.
     */
    @PostMapping(path = "/login")
    public final Map<String, String> loginCandidate(
            @Valid final @RequestBody LoginRequestDto loginRequestDto) {
        LOGGER.info("Login method invoke");
        Map<String, String> response = candidateService.
                loginCandidate(loginRequestDto);
        LOGGER.info("Login successfully");
        return response;
    }
    /**
     * End point to retrieve a list of all candidates.
     *@return A list of candidate DTOs.
     */
    @GetMapping(path = "/all")
    public final List<CandidateDto> allCandidate() {
        LOGGER.info("Retrieving list of Candidates");
        List<CandidateDto>  candidates = candidateService.getAllCandidate();
        LOGGER.info("Retrieved list of candidates");
        return candidates;
    }
}
