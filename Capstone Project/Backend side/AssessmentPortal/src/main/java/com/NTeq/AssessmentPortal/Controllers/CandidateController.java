package com.NTeq.AssessmentPortal.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NTeq.AssessmentPortal.Dto.CandidateDto;
import com.NTeq.AssessmentPortal.Services.impl.CandidateServiceImpl;

/**
 * Controller class that handles HTTP requests related to candidate operations.
 */
@CrossOrigin
@RestController
@RequestMapping("/candidate")
public class CandidateController {
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
    public final String saveUser(final @RequestBody CandidateDto cdDto) {

        return candidateService.addCandidate(cdDto);
    }
    /**
     * End point for candidate login.
     * @param cdDto The candidate DTO containing login credentials.
     * @return A map containing login response status and message.
     */
    @PostMapping(path = "/login")
    public final Map<String, String> loginCandidate(
            final @RequestBody CandidateDto cdDto) {
        Map<String, String> response = candidateService.loginCandidate(cdDto);
        return response;
    }
    /**
     * End point to retrieve a list of all candidates.
     *@return A list of candidate DTOs.
     */
    @GetMapping(path = "/all")
    public final List<CandidateDto> allCandidate() {
        return candidateService.getAllCandidate();
    }

}
