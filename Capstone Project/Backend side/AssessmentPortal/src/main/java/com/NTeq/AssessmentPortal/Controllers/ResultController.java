package com.NTeq.AssessmentPortal.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.NTeq.AssessmentPortal.Dto.ResultDto;
import com.NTeq.AssessmentPortal.Services.impl.ResultServiceImpl;

import jakarta.validation.Valid;

/**
 * Controller class that handles HTTP requests related to result operations.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/result")
public class ResultController {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ResultController.class);
    /**
     * The ResultService implementation that handles result operations.
     * This field is automatically injected by the @Autowired annotation.
     */
    @Autowired
    private ResultServiceImpl resultService;
    /**
     * End point to add a new result.
     * @param resultDto The result DTO containing result details.
     * @return A message indicating the addition status.
     */
    @PostMapping("/addResult")
    public final String saveResult(@Valid final @RequestBody
            ResultDto resultDto) {
        LOGGER.info("Add Result method invoked");
        String result = resultService.addResult(resultDto);
        LOGGER.info("Result created succesfully");
        return result;
    }
    /**
     * End point to retrieve a list of all result.
     * @return A list of result DTOs.
     */
    @GetMapping("/all")
    public final ResponseEntity<List<ResultDto>> getAll() {
        LOGGER.info("Get results method invoked");
        List<ResultDto> reportDtos = resultService.getAllResult();
        LOGGER.info("Retrieved Results Successfully");
        return ResponseEntity.ok(reportDtos);
    }
    /**
     * End point to retrieve a list of all result.
     * @param email   the email of the candidate.
     * @return A list of result DTOs.
     */
    @GetMapping("/{email}")
    public final ResponseEntity<List<ResultDto>> findByEmailId(
           final @PathVariable String email) {
        LOGGER.info("Getting result by email: {}",email);
        List<ResultDto> resultDto = resultService.getresultByEmail(email);
        LOGGER.info("Successfully fetched result with email {}",email);
           return ResponseEntity.ok(resultDto);
        
    }
}
