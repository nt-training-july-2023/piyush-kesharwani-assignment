package com.NTeq.AssessmentPortal.Services;

import java.util.List;

import com.NTeq.AssessmentPortal.Dto.ResultDto;
import com.NTeq.AssessmentPortal.Response.SuccessResponse;

/**
 * Service interface for managing result-related operations.
 */
public interface ResultService {
    /**
     * Adds a new result to the system.
     * @param resultDto The DTO containing result details.
     * @return A message indicating the result of the operation.
     */
    SuccessResponse addResult(ResultDto resultDto);
    /**
     * Retrieves a list of all results.
     * @return A list of result DTOs.
     */
    List<ResultDto> getAllResult();
    /**
     * Retrieves a list of all results.
     * @param userEmail   the email of users, whom result should be generated.
     * @return A list of result DTOs.
     */
    List<ResultDto> getresultByEmail(String userEmail);
}
