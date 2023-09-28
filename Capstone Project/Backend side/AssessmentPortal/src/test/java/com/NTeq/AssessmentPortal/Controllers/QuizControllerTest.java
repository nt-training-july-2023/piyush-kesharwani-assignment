package com.NTeq.AssessmentPortal.Controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.NTeq.AssessmentPortal.Dto.QuizDto;
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
        when(quizService.addQuiz(quizDto)).thenReturn("Quiz added successfully");

        String result = quizController.saveQuiz(quizDto);

        assertEquals("Quiz added successfully", result);
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
        ResponseEntity<QuizDto> responseEntity = quizController.updateQuiz(quizId, quizDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(quizDto, responseEntity.getBody());
    }

    @Test
    void testDeleteQuiz_Success() {
        long quizId = 1L;
        doNothing().when(quizService).deleteQuiz(quizId);

        ResponseEntity<Void> responseEntity = quizController.deleteQuiz(quizId);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }
}
