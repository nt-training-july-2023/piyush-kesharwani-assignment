package com.NTeq.AssessmentPortal.Services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import com.NTeq.AssessmentPortal.Dto.CategoryDto;
import com.NTeq.AssessmentPortal.Dto.QuestionDto;
import com.NTeq.AssessmentPortal.Dto.QuizDto;
import com.NTeq.AssessmentPortal.Entity.Category;
import com.NTeq.AssessmentPortal.Entity.Options;
import com.NTeq.AssessmentPortal.Entity.Question;
import com.NTeq.AssessmentPortal.Entity.Quiz;
import com.NTeq.AssessmentPortal.Exceptions.ResourceNotFound;
import com.NTeq.AssessmentPortal.Repositories.QuestionRepository;
import com.NTeq.AssessmentPortal.Response.Message;
import com.NTeq.AssessmentPortal.Response.SuccessResponse;

class QuestionServiceImplTest {
    @InjectMocks
    private QuestionServiceImpl questionService;
    @Mock
    private QuestionServiceImpl questionService2;
    @Mock
    private QuestionRepository questionRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
  
    @Test
    public void testAddQuestionSuccess() {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionId(1);
        questionDto.setQuestionName("Which is not a programming language");
        Options options = new Options("Java", "C++", "MYSQL", "Python");
        questionDto.setOptions(options);
        questionDto.setAnswer(options.getOptionThree());
        CategoryDto category = new CategoryDto(11, "Programming language",
                "Programming language mcqs");
        QuizDto quizDTO = new QuizDto(111, "Java", "Java mcqs",
                category,10);
        questionDto.setQuiz(quizDTO);
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionName("Which is not a programming language");
        question.setOptionOne("Java");
        question.setOptionTwo("C++");
        question.setOptionThree("MYSQL");
        question.setOptionFour("Python");
        question.setAnswer("OptionIII");
        Category categoryEntity = new Category(11, "Programming language",
                "Programming language mcqs");
        Quiz quiz = new Quiz();
        quiz.setQuizId(111);
        quiz.setQuizName("Java");
        quiz.setQuizDescription("Java mcqs");
        quiz.setCategory(categoryEntity);
        quiz.setTime(10);
        question.setQuiz(quiz);
        
        SuccessResponse expectedResponse = new SuccessResponse(HttpStatus.CREATED.value(),
                Message.QUESTION_CREATED_SUCCESSFULLY);
        when(questionService2.dtoToQuestion(questionDto)).thenReturn(question);
        when(questionRepository.save(question)).thenReturn(question);
        
        SuccessResponse result = questionService.addQuestion(questionDto);
        assertEquals(expectedResponse, result);
    }

    @Test
    void testgetAllQuestions_Success() {
        Category category = new Category(11, "Programming language",
                "Programming language mcqs");
       Quiz qz = new Quiz(111,"Java","Java mcqs",category,10);
        Question question = new Question();
        question.setQuestionId(111);
        question.setQuestionName("Which is not a programming language");
        question.setOptionOne("Java");
        question.setOptionTwo("Python");
        question.setOptionThree("MYSQL");
        question.setOptionFour("C++");
        question.setAnswer("MYSQL");
        question.setQuiz(qz);
        
        List<Question> questions = new ArrayList<>();
        questions.add(question);

        when(questionRepository.findAll()).thenReturn(questions);
        List<QuestionDto> questionDtos = questionService.getAllQuestion();

        assertNotNull(questionDtos);
        assertEquals(1, questionDtos.size());
    }
    
    @Test
    void testGetQuestionById_Success() {
        long questionId = 1;
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionId(questionId);
        questionDto.setQuestionName("Which is not a programming language");
        Options options = new Options("Java", "C++", "MYSQL", "Python");
        questionDto.setOptions(options);
        questionDto.setAnswer(options.getOptionThree());
        CategoryDto category = new CategoryDto(11, "Programming language",
                "Programming language mcqs");
        QuizDto quizDTO = new QuizDto(111, "Java", "Java mcqs",
                category,10);
        questionDto.setQuiz(quizDTO);

        Question question = new Question();
        question.setQuestionId(questionDto.getQuestionId());
        question.setQuestionName(questionDto.getQuestionName());
        question.setOptionOne(questionDto.getOptions().getOptionOne());
        question.setOptionTwo(questionDto.getOptions().getOptionTwo());
        question.setOptionThree(questionDto.getOptions().getOptionThree());
        question.setOptionFour(questionDto.getOptions().getOptionFour());
        question.setAnswer(questionDto.getAnswer());
        Category categoryEntity = new Category(11, "Programming language",
                "Programming language mcqs");
        Quiz quiz = new Quiz();
        quiz.setQuizId(111);
        quiz.setQuizName("Java");
        quiz.setQuizDescription("Java mcqs");
        quiz.setCategory(categoryEntity);
        quiz.setTime(10);
        question.setQuiz(quiz);

        when(questionService2.questionToDto(question)).thenReturn(questionDto);
        when(questionRepository.findById(question.getQuestionId())).thenReturn(Optional.of(question));
        when(questionRepository.save(any(Question.class))).thenReturn(question);

        QuestionDto result = questionService.getQuestionById(1);
        assertNotNull(result);
        assertEquals(questionId, result.getQuestionId());
    }
    @Test
    public void testGetQuestionById_ResourceNotFound() {
        long questionId = 1;

        when(questionRepository.findById(questionId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () -> questionService.getQuestionById(questionId));
    }
    
    @Test
    void testUpdateQuestion_Success() {
        long questionIdToUpdate = 1L;
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionId(1);
        questionDto.setQuestionName("Which is not a programming language");
        Options options = new Options("Java", "c++", "MYSQL", "Python");
        questionDto.setOptions(options);
        questionDto.setAnswer(options.getOptionThree());
        CategoryDto category = new CategoryDto(11, "Programming language",
                "Programming language mcqs");
        QuizDto quizDTO = new QuizDto(111, "Java", "Java mcqs",
                category,10);
        questionDto.setQuiz(quizDTO);

        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionName(questionDto.getQuestionName());
        question.setOptionOne(questionDto.getOptions().getOptionOne());
        question.setOptionTwo(questionDto.getOptions().getOptionTwo());
        question.setOptionThree(questionDto.getOptions().getOptionThree());
        question.setOptionFour(questionDto.getOptions().getOptionFour());
        question.setAnswer(questionDto.getAnswer());
        Category categoryEntity = new Category(11, "Programming language",
                "Programming language mcqs");
        Quiz quiz = new Quiz();
        quiz.setQuizId(111);
        quiz.setQuizName("Java");
        quiz.setQuizDescription("Java mcqs");
        quiz.setCategory(categoryEntity);
        quiz.setTime(10);
        question.setQuiz(quiz);

        SuccessResponse expectedResponse = new SuccessResponse(HttpStatus.OK.value(),
                Message.QUESTION_UPDATED_SUCCESSFULLY);
        
        when(questionService2.dtoToQuestion(questionDto)).thenReturn(question);
        when(questionRepository.findById(questionIdToUpdate)).thenReturn(Optional.of(question));
        when(questionRepository.save(question)).thenReturn(question);

        SuccessResponse result = questionService.updateQuestion(questionIdToUpdate, questionDto);
        assertEquals(expectedResponse, result);
    }
    
    @Test
    void testUpdateQuiz_QuestionNotFound() {
        long questionIdToUpdate = 123L;
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionId(1);
        questionDto.setQuestionName("Which is not a programming language");
        Options options = new Options("Java", "c++", "MYSQL", "Python");
        questionDto.setOptions(options);
        questionDto.setAnswer(options.getOptionThree());
        CategoryDto category = new CategoryDto(11, "Programming language",
                "Programming language mcqs");
        QuizDto quizDTO = new QuizDto(111, "Java", "Java mcqs",
                category,10);
        questionDto.setQuiz(quizDTO);

        Question question = new Question();
        question.setQuestionId(123);
        question.setQuestionName(questionDto.getQuestionName());
        question.setOptionOne(questionDto.getOptions().getOptionOne());
        question.setOptionTwo(questionDto.getOptions().getOptionTwo());
        question.setOptionThree(questionDto.getOptions().getOptionThree());
        question.setOptionFour(questionDto.getOptions().getOptionFour());
        question.setAnswer(questionDto.getAnswer());
        Category categoryEntity = new Category(11, "Programming language",
                "Programming language mcqs");
        Quiz quiz = new Quiz();
        quiz.setQuizId(111);
        quiz.setQuizName("Java");
        quiz.setQuizDescription("Java mcqs");
        quiz.setCategory(categoryEntity);
        quiz.setTime(10);
        question.setQuiz(quiz);
        
        SuccessResponse expectedResponse = new SuccessResponse(HttpStatus.NOT_FOUND.value(),
                Message.QUESTION_NOT_FOUND);

        when(questionService2.dtoToQuestion(questionDto)).thenReturn(question);
        when(questionRepository.findById(questionIdToUpdate)).thenReturn(Optional.empty());
        SuccessResponse result = questionService.updateQuestion(questionIdToUpdate, questionDto);
        
        assertEquals(expectedResponse,result);
    }
    @Test
    void testDeleteQuestion_Success(){
        long questionIdToDelete = 1;
        SuccessResponse expectedResponse = new SuccessResponse(HttpStatus.OK.value(),
                Message.QUESTION_DELETED_SUCCESSFULLY);
        when(questionRepository.findById(questionIdToDelete)).thenReturn(Optional.of(new Question()));
  
        SuccessResponse result = questionService.deleteQuestion(questionIdToDelete);
        assertEquals(expectedResponse,result);
    }
}
