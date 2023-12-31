package com.NTeq.AssessmentPortal.Services;

import java.util.List;
import java.util.Map;

import com.NTeq.AssessmentPortal.Dto.CandidateDto;

/**
 * Service interface for managing candidate-related operations.
 */
public interface CandidateService {
    /**
     * Adds a new candidate to the system.
     * @param cdDto The DTO containing candidate details.
     * @return A message indicating the result of the operation.
     */
    String addCandidate(CandidateDto cdDto);

    /**
     * Logs in a candidate using provided credentials.
     * @param inCandidateDto The DTO containing candidate login credentials.
     * @return A map with login response status and message.
     */
    Map<String, String> loginCandidate(CandidateDto inCandidateDto);

    /**
     * Retrieves a list of all candidates.
     * @return A list of candidate DTOs.
     */
    List<CandidateDto> getAllCandidate();
}


