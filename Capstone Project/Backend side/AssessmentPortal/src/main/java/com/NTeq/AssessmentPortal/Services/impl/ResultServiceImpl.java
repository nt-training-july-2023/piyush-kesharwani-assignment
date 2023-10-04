package com.NTeq.AssessmentPortal.Services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.NTeq.AssessmentPortal.Dto.ResultDto;
import com.NTeq.AssessmentPortal.Entity.Result;
import com.NTeq.AssessmentPortal.Exceptions.ResourceNotFound;
import com.NTeq.AssessmentPortal.Repositories.ResultRepository;
import com.NTeq.AssessmentPortal.Response.Message;
import com.NTeq.AssessmentPortal.Response.SuccessResponse;
import com.NTeq.AssessmentPortal.Services.ResultService;
/**
 * Service implementation for managing Result-related operations.
 */
@Service
public class ResultServiceImpl implements ResultService {
    /**
     * This class represents a logger for the ResultServiceImpl.
     */
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
    public final SuccessResponse addResult(final ResultDto resultDto) {
        Result result = this.dtoToResult(resultDto);
        resultRepository.save(result);
        return new SuccessResponse(HttpStatus.CREATED.value(),
                Message.RESULT_CREATED_SUCCESSFULLY);
    }

    @Override
    public final List<ResultDto> getAllResult() {
        List<Result> result = this.resultRepository.findAll();
        List<ResultDto> resultDtos = result.stream()
                .map(rs -> this.resultToDto(rs))
                .collect(Collectors.toList());
        return resultDtos;
    }
    @Override
    public final List<ResultDto> getresultByEmail(final String userEmail) {
        List<Result> result = this.resultRepository.findByUserEmail(userEmail);
        if (result.isEmpty()) {
            LOGGER.error(Message.RESULT_NOT_FOUND);
            throw new ResourceNotFound(Message.RESULT_NOT_FOUND);
        }
        List<ResultDto> resultDtos = result.stream()
                .map(rs -> this.resultToDto(rs))
                .collect(Collectors.toList());
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
