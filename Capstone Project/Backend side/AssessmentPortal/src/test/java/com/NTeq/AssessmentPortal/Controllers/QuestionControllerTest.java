package com.NTeq.AssessmentPortal.Controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.NTeq.AssessmentPortal.Dto.QuestionDto;
import com.NTeq.AssessmentPortal.Response.SuccessResponse;
import com.NTeq.AssessmentPortal.Services.impl.QuestionServiceImpl;

class QuestionControllerTest {

    @InjectMocks
    private QuestionController questionController;

    @Mock
    private QuestionServiceImpl questionService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddQuestion() {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionName("Sample question text");
        
        SuccessResponse response = new SuccessResponse(HttpStatus.CREATED.value(),
                "Question created successfully.");
        when(questionService.addQuestion(questionDto)).thenReturn(response);
        ResponseEntity<SuccessResponse> result = questionController.addQuestion(questionDto);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(response, result.getBody());
    }

    @Test
    public void testGetAll() {
        List<QuestionDto> questionDtoList = new ArrayList<>();
        when(questionService.getAllQuestion()).thenReturn(questionDtoList);
        List<QuestionDto> response = questionController.getAll();
        assertEquals(questionDtoList, response);
    }
    
    @Test
    public void testGetQuestionById() {
        long questionId = 1L;
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionId(questionId);
        when(questionService.getQuestionById(questionId)).thenReturn(questionDto);
        ResponseEntity<QuestionDto> response = questionController.getQuestionById(questionId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(questionDto, response.getBody());
    }
    
    @Test
    public void testUpdateQuestion() {
        long questionId = 1L;
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionId(questionId);
        SuccessResponse response = new SuccessResponse(HttpStatus.OK.value(),
                "Question updated successfully.");
        when(questionService.updateQuestion(questionId, questionDto)).thenReturn(response);
        ResponseEntity<SuccessResponse> result = questionController.updateQuestion(questionId, questionDto);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(response, result.getBody());
    }
    
    @Test
    public void testDeleteQuestion() {
        long questionId = 1L;
        SuccessResponse response = new SuccessResponse(HttpStatus.OK.value(),
                "Question deleted successfully.");
        when(questionService.deleteQuestion(questionId)).thenReturn(response);
        ResponseEntity<SuccessResponse> result = questionController.deleteQuestion(questionId);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(response , result.getBody());
    }
}
