package com.NTeq.AssessmentPortal.Services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.NTeq.AssessmentPortal.Dto.ResultDto;
import com.NTeq.AssessmentPortal.Entity.Result;
import com.NTeq.AssessmentPortal.Repositories.ResultRepository;

class ResultServiceImplTest {

   @Mock
   private ResultRepository resultRepository;
   
   @Mock
   private ModelMapper modelMapper;
   
   @InjectMocks
   private ResultServiceImpl resultService;
   
   @BeforeEach
   public void setup() {
       MockitoAnnotations.openMocks(this);
   }
   
   @Test
   public void addResult() {
       ResultDto resultDto = new ResultDto();
       resultDto.setResultId(10);
       resultDto.setTotalMarks(100);
       resultDto.setObtainedMarks(90);
       resultDto.setUserEmail("Aakash@nucleusTeq.com");
       resultDto.setUserName("Aakash Singh");
       resultDto.setDateTime("12/07/23 05:34:45");
       resultDto.setQuizName("SpringBoot");
       resultDto.setCategoryName("Java");
       resultDto.setAttemptedQuestion(95);
       resultDto.setTotalQuestion(100);
       
       Result result = new Result();
       result.setResultId(resultDto.getResultId());
       result.setTotalMarks(resultDto.getTotalMarks());
       result.setObtainedMarks(resultDto.getObtainedMarks());
       result.setUserEmail(resultDto.getUserEmail());
       result.setUserName(resultDto.getUserName());
       result.setDateTime(resultDto.getDateTime());
       result.setQuizName(resultDto.getQuizName());
       result.setCategoryName(resultDto.getCategoryName());
       result.setAttemptedQuestion(resultDto.getAttemptedQuestion());
       result.setTotalQuestion(resultDto.getTotalQuestion());
       
       when(modelMapper.map(resultDto,Result.class )).thenReturn(result);
       when(resultRepository.save(result)).thenReturn(result);
       String answer = resultService.addResult(resultDto);
       assertEquals("Result created successfully" , answer);
   }
   

   @Test
   public void testGetAllResult() {
       Result result1 = new Result();
       result1.setResultId(1);
       Result result2 = new Result();
       result2.setResultId(2);

       List<Result> resultList = Arrays.asList(result1, result2);
       when(resultRepository.findAll()).thenReturn(resultList);
       List<ResultDto> resultDtos = resultService.getAllResult();
       assertNotNull(resultDtos);
       assertEquals(2, resultDtos.size());
   }

   @Test
   public void testGetResultByEmail() {
       String userEmail = "test@example.com";
       Result result1 = new Result();
       result1.setResultId(1);
       result1.setUserEmail(userEmail);

       Result result2 = new Result();
       result2.setResultId(2);
       result2.setUserEmail(userEmail);

       List<Result> resultList = Arrays.asList(result1, result2);

       when(resultRepository.findByUserEmail(userEmail)).thenReturn(resultList);
       List<ResultDto> resultDtos = resultService.getresultByEmail(userEmail);
       assertNotNull(resultDtos);
       assertEquals(2, resultDtos.size());
   }

}
