package com.NTeq.AssessmentPortal.Controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
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
        when(questionService.addQuestion(questionDto)).thenReturn("Question added successfully");
        ResponseEntity<String> response = questionController.addQuestion(questionDto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Question added successfully", response.getBody());
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
        when(questionService.updateQuestion(questionId, questionDto)).thenReturn("Question updated successfully");
        ResponseEntity<QuestionDto> response = questionController.updateQuestion(questionId, questionDto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(questionDto, response.getBody());
    }
    
    @Test
    public void testDeleteQuestion() {
        long questionId = 1L;
        doNothing().when(questionService).deleteQuestion(questionId);
        ResponseEntity<Void> response = questionController.deleteQuestion(questionId);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
