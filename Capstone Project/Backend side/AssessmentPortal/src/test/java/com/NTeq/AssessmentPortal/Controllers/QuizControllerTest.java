package com.NTeq.AssessmentPortal.Controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.NTeq.AssessmentPortal.Dto.QuestionDto;
import com.NTeq.AssessmentPortal.Dto.QuizDto;
import com.NTeq.AssessmentPortal.Response.SuccessResponse;
import com.NTeq.AssessmentPortal.Services.impl.QuizServiceImpl;

class QuizControllerTest {

    @InjectMocks
    private QuizController quizController;

    @Mock
    private QuizServiceImpl quizService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveQuiz() {
        QuizDto quizDto = new QuizDto();
        
        SuccessResponse response = new SuccessResponse(HttpStatus.CREATED.value(),
                "Quiz created successfully.");
        ResponseEntity<SuccessResponse> expectedResponse = new ResponseEntity<SuccessResponse>(
                response,HttpStatus.CREATED);
        when(quizService.addQuiz(quizDto)).thenReturn(response);

        ResponseEntity<SuccessResponse> result = quizController.saveQuiz(quizDto);
        
        assertEquals(expectedResponse, result);
    }
    
    @Test
    void testGetAll() {
        List<QuizDto> quizDtoList = Arrays.asList(new QuizDto(), new QuizDto());
        when(quizService.getAllQuiz()).thenReturn(quizDtoList);

        List<QuizDto> result = quizController.getAll();

        assertEquals(2, result.size());
    }

    @Test
    void testUpdateQuiz_Success() {
        long quizId = 1L;
        QuizDto quizDto = new QuizDto();
        SuccessResponse response = new SuccessResponse(HttpStatus.OK.value(),
                "Quiz updated successfully.");
        ResponseEntity<SuccessResponse> expectedResponse = new ResponseEntity<SuccessResponse>(
                response,HttpStatus.OK);
        
        when(quizService.updateQuiz(quizId, quizDto)).thenReturn(response);
        ResponseEntity<SuccessResponse> result = quizController.updateQuiz(quizId, quizDto);

        assertEquals(expectedResponse, result);
    }

    @Test
    void testDeleteQuiz_Success() {
        long quizId = 1L;
        SuccessResponse response = new SuccessResponse(HttpStatus.OK.value(),
                "Quiz deleted successfully.");
        ResponseEntity<SuccessResponse> expectedResponse = new ResponseEntity<SuccessResponse>(
                response,HttpStatus.OK);

        when(quizService.deleteQuiz(quizId)).thenReturn(response);
        ResponseEntity<SuccessResponse> result = quizController.deleteQuiz(quizId);

        assertEquals(expectedResponse , result);
    }
    
    @Test
    void testGetQuiz() {
        long quizId = 1L;
        QuizDto quizDto = new QuizDto();
        ResponseEntity<QuizDto> expectedResponse = new ResponseEntity<QuizDto>(
                quizDto,HttpStatus.OK);
        
        when(quizService.getQuizById(quizId)).thenReturn(quizDto);
        
        ResponseEntity<QuizDto> result = quizController.getQuiz(quizId);
        
        assertEquals(expectedResponse , result);
    }
    
    @Test
    void testGetQuestionsByQuiz() {
        int quizId = 10;
        List<QuestionDto> questionDto = new ArrayList<>();
        
        when(quizService.getAllQuestionByQuiz(quizId)).thenReturn(questionDto);
        
        List<QuestionDto> result = quizController.getAllQuestionByQuiz(quizId);
        
        assertEquals(questionDto , result);
    }
}
