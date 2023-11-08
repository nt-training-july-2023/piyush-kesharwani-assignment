package com.NTeq.AssessmentPortal.Services.impl;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

import com.NTeq.AssessmentPortal.Dto.QuestionDto;
import com.NTeq.AssessmentPortal.Dto.QuizDto;
import com.NTeq.AssessmentPortal.Entity.Category;
import com.NTeq.AssessmentPortal.Entity.Question;
import com.NTeq.AssessmentPortal.Entity.Quiz;
import com.NTeq.AssessmentPortal.Exceptions.AlreadyExistException;
import com.NTeq.AssessmentPortal.Exceptions.ResourceNotFound;
import com.NTeq.AssessmentPortal.Repositories.CategoryRepository;
import com.NTeq.AssessmentPortal.Repositories.QuizRepository;
import com.NTeq.AssessmentPortal.Response.Message;
import com.NTeq.AssessmentPortal.Response.SuccessResponse;
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

    @Mock
    private QuizServiceImpl quizService2;
    
    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddQuiz() {
        QuizDto quizDto = new QuizDto();
        quizDto.setQuizName("Sample Quiz");

        Quiz quiz = new Quiz();
        Category category = new Category();
        quiz.setCategory(category);
        when(quizRepository.findByQuizName(quizDto.getQuizName())).thenReturn(Optional.empty());
        when(categoryRepository.findById(quiz.getCategory().getCategoryId())).thenReturn(Optional.of(category));
        when(modelMapper.map(quizDto, Quiz.class)).thenReturn(quiz);
        when(quizRepository.save(any(Quiz.class))).thenReturn(quiz);
        
        SuccessResponse expectedResponse = new SuccessResponse(HttpStatus.CREATED.value(),
                Message.QUIZ_CREATED_SUCCESSFULLY);
        
        SuccessResponse result = quizService.addQuiz(quizDto);
        assertEquals(expectedResponse, result);
    }
    @Test
    public void testAddQuiz_QuizAlreadyExist() {
        QuizDto quizDto = new QuizDto();
        quizDto.setQuizName("Sample Quiz");

        Quiz quiz = new Quiz();
        Category category = new Category();
        quiz.setCategory(category);
        
        when(quizRepository.findByQuizName("Sample Quiz")).thenReturn(Optional.of(quiz));
        assertThrows(AlreadyExistException.class, () -> {
            quizService.addQuiz(quizDto);
        });
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
        long quizId = 1;
        Quiz quiz = new Quiz();
        quiz.setQuizId(quizId);
        
        QuizDto quizDto = new QuizDto();
        quizDto.setQuizId(quizId);
        when(quizRepository.findById(quizId)).thenReturn(Optional.of(quiz));
        when(modelMapper.map(quiz, QuizDto.class)).thenReturn(quizDto);

        QuizDto result = quizService.getQuizById(quizId);
        assertNotNull(result);
        assertEquals(quizDto, result);
    }
    @Test
    public void testGetQuizById_ResourceNotFound() {
        long quizId = 1;

        when(quizRepository.findById(quizId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () -> quizService.getQuizById(quizId));
    }
    
    @Test
    public void testUpdateQuiz() {
        long quizId = 1L;
        QuizDto updatedQuizDto = new QuizDto();
        Quiz updatedQuiz = new Quiz();
        updatedQuiz.setQuizName("quiz 1");

        when(modelMapper.map(updatedQuizDto, Quiz.class)).thenReturn(updatedQuiz);
        SuccessResponse expectedResponse = new SuccessResponse(HttpStatus.OK.value(),
                Message.QUIZ_UPDATED_SUCCESSFULLY);

        SuccessResponse result = quizService.updateQuiz(quizId, updatedQuizDto);

        assertEquals(expectedResponse, result);
    }
   
    @Test
    public void testDeleteQuiz() {
        long quizId = 1L;
        Quiz quiz = new Quiz();
        quiz.setQuizId(quizId);
        SuccessResponse expectedResponse = new SuccessResponse(HttpStatus.NO_CONTENT.value(),
                Message.QUIZ_DELETED_SUCCESSFULLY);

        SuccessResponse result = quizService.deleteQuiz(quizId);
        assertEquals(expectedResponse,result);

    }
    
    @Test
    public void testGetAllQuestionByQuiz() {

        long quizId = 1L;
        Quiz quiz = new Quiz();
        quiz.setQuizId(quizId);
        quiz.setCategory(new Category());
        
        List<Question> questions = new ArrayList<>();
        Question question = new Question();
        question.setQuestionId(111);
        question.setQuestionName("Which is not a programming language");
        question.setOptionOne("Java");
        question.setOptionTwo("Python");
        question.setOptionThree("MYSQL");
        question.setOptionFour("C++");
        question.setAnswer("MYSQL");
        question.setQuiz(quiz);
        questions.add(question);
        quiz.setQuestion(questions);
        
        when(quizRepository.findById(quizId)).thenReturn(Optional.of(quiz));
        List<QuestionDto> questionDto = quizService.getAllQuestionByQuiz(quizId);
        
        assertNotNull(questionDto);
        assertEquals(1,questionDto.size());
        
    }

}
