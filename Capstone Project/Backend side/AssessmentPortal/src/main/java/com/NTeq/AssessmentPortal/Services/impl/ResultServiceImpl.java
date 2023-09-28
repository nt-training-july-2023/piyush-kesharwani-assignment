package com.NTeq.AssessmentPortal.Services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NTeq.AssessmentPortal.Dto.ResultDto;
import com.NTeq.AssessmentPortal.Entity.Result;
import com.NTeq.AssessmentPortal.Repositories.ResultRepository;
import com.NTeq.AssessmentPortal.Services.ResultService;
/**
 * Service implementation for managing Result-related operations.
 */
@Service
public class ResultServiceImpl implements ResultService {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ResultServiceImpl.class);
    /**
     * Repository for result data. Injected by Spring using @Autowired.
     */
    @Autowired
    private ResultRepository resultRepository;
  /**
   * Object mapper for DTO-entity mapping.Injected by Spring using @Autowired.
   */
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public final String addResult(final ResultDto resultDto) {
        LOGGER.info("Adding a new result");
        Result result = this.dtoToResult(resultDto);
        resultRepository.save(result);
        LOGGER.info("Result created successfully");
        return "Result created successfully";
    }

    @Override
    public final List<ResultDto> getAllResult() {
        LOGGER.info("Getting all results");
        List<Result> result = this.resultRepository.findAll();
        List<ResultDto> resultDtos = result.stream()
                .map(rs -> this.resultToDto(rs))
                .collect(Collectors.toList());
        LOGGER.info("Retrieved {} results", resultDtos.size());
        return resultDtos;
    }
    @Override
    public final List<ResultDto> getresultByEmail(final String userEmail) {
        LOGGER.info("Getting results by email: {}", userEmail);
        List<Result> result = this.resultRepository.findByUserEmail(userEmail);
        List<ResultDto> resultDtos = result.stream()
                .map(rs -> this.resultToDto(rs))
                .collect(Collectors.toList());
        LOGGER.info("Retrieved {} results for email: {}", resultDtos.size()
                , userEmail);
        return resultDtos;
    }
    /**
     * Converts a ResultDto to its corresponding entity.
     * @param resultDto The ResultDto.
     * @return The corresponding Result entity.
     */
    public final Result dtoToResult(final ResultDto resultDto) {
        Result result = this.modelMapper.map(resultDto, Result.class);
        return result;
    }
    /**
     * Converts a result entity to its corresponding DTO.
     * @param result The Result entity.
     * @return The corresponding ResultDto.
     */
    public final ResultDto resultToDto(final Result result) {
        ResultDto resultDto = modelMapper.map(result, ResultDto.class);
        return resultDto;
    }
}
