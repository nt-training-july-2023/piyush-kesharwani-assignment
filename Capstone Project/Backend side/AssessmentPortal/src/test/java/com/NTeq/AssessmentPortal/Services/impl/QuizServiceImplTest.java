package com.NTeq.AssessmentPortal.Services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.NTeq.AssessmentPortal.Dto.QuizDto;
import com.NTeq.AssessmentPortal.Entity.Quiz;
import com.NTeq.AssessmentPortal.Exceptions.ResourceNotFound;
import com.NTeq.AssessmentPortal.Repositories.CategoryRepository;
import com.NTeq.AssessmentPortal.Repositories.QuizRepository;
@ExtendWith(MockitoExtension.class)
class QuizServiceImplTest {
    
    @Mock
    private QuizRepository quizRepository;
    
    @Mock
    private CategoryRepository categoryRepository;
    
    @Mock
    private ModelMapper modelMapper;
    
    @InjectMocks
    private QuizServiceImpl quizService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testAddQuiz() {
        QuizDto quizDTO = new QuizDto();
        quizDTO.setQuizId(0);
        quizDTO.setQuizName("Sample Quiz");
        quizDTO.setQuizDescription("this is description");
        quizDTO.setTime(60);
        quizDTO.setCategory(null);

        Quiz quiz = new Quiz();
        when(modelMapper.map(quizDTO, Quiz.class)).thenReturn(quiz);
        when(quizRepository.save(any(Quiz.class))).thenReturn(quiz);
        String result = quizService.addQuiz(quizDTO);
        
        assertEquals(result, "Quiz added successfully");
    }
    
    @Test
    public void testGetAllQuiz() {
        List<Quiz> quizzes = new ArrayList<>();
        quizzes.add(new Quiz());
        quizzes.add(new Quiz());
        when(quizRepository.findAll()).thenReturn(quizzes);
        List<QuizDto> result = quizService.getAllQuiz();
        assertEquals(quizzes.size(), result.size());
    }
    
    @Test
    public void testGetQuizById() {
        // Mocking data
        long quizId = 1;
        Quiz quiz = new Quiz();
        quiz.setQuizId(quizId);
        
        QuizDto quizDto = new QuizDto();
        
        // Mocking repository behavior
        when(quizRepository.findById(quizId)).thenReturn(Optional.of(quiz));
        when(modelMapper.map(quiz, QuizDto.class)).thenReturn(quizDto);

        // Test the method
        QuizDto result = quizService.getQuizById(quizId);

        // Assertions
        assertNotNull(result);
        assertEquals(quizDto.getQuizId(), result.getQuizId());
    }
    @Test
    public void testGetQuizById_ResourceNotFound() {
        int quizId = 1;

        when(quizRepository.findById((long) quizId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () -> quizService.getQuizById(quizId));
    }
    
    @Test
    public void testUpdateQuiz() {
        // Mocking data
        long quizId = 1L;
        QuizDto updatedQuizDto = new QuizDto();
        Quiz updatedQuiz = new Quiz();

        // Mocking repository behavior
        when(modelMapper.map(updatedQuizDto, Quiz.class)).thenReturn(updatedQuiz);

        // Test the method
        String result = quizService.updateQuiz(quizId, updatedQuizDto);

        // Assertions
        assertEquals("Updated successfully..", result);
//        verify(quizRepository, times(1)).save(updatedQuiz);
    }
   
    @Test
    public void testDeleteQuiz() {
        // Mocking data
        long quizId = 1L;

        // Test the method
        quizService.deleteQuiz(quizId);

        // Verify that deleteById was called with the expected quizId
        verify(quizRepository, times(1)).deleteById(quizId);
    }

    

}
