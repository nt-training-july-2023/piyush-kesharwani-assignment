package com.NTeq.AssessmentPortal.Services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.NTeq.AssessmentPortal.Dto.CategoryDto;
import com.NTeq.AssessmentPortal.Dto.QuestionDto;
import com.NTeq.AssessmentPortal.Dto.QuizDto;
import com.NTeq.AssessmentPortal.Entity.Category;
import com.NTeq.AssessmentPortal.Entity.Options;
import com.NTeq.AssessmentPortal.Entity.Question;
import com.NTeq.AssessmentPortal.Entity.Quiz;
import com.NTeq.AssessmentPortal.Exceptions.AlreadyExistException;
import com.NTeq.AssessmentPortal.Exceptions.ResourceNotFound;
import com.NTeq.AssessmentPortal.Repositories.CategoryRepository;
import com.NTeq.AssessmentPortal.Repositories.QuizRepository;
import com.NTeq.AssessmentPortal.Response.Message;
import com.NTeq.AssessmentPortal.Response.SuccessResponse;
import com.NTeq.AssessmentPortal.Services.QuizService;
/**
 * Service implementation for managing Quiz-related operations.
 */
@Service
public class QuizServiceImpl implements QuizService {
    /**
     * This class represents a logger for the QuizServiceImpl.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(QuizServiceImpl.class);
    /**
     * Repository for Quiz data. Injected by Spring using @Autowired.
     */
    @Autowired
    private QuizRepository quizRepository;
    /**
     * Repository for Category data. Injected by Spring using @Autowired.
     */
    @Autowired
    private CategoryRepository categoryRepository;
    /**
     * Object Mapper for DTO-entity mapping.Injected by Spring using @Autowired.
     */
    @Autowired
    private ModelMapper modelMapper;
    /**
     * Adds a new quiz using the provided QuizDto.
     * @param quizDto The QuizDto containing quiz information.
     * @return A message indicating the success of the operation.
     */
    @Override
    public final SuccessResponse addQuiz(final QuizDto quizDto) {
        Optional<Quiz> existingQuiz = quizRepository.findByQuizName(
                quizDto.getQuizName());
        if (existingQuiz.isPresent()) {
            LOGGER.error(Message.QUIZ__ALREADY_EXISTS + quizDto.getQuizName());
            throw new AlreadyExistException(Message.QUIZ__ALREADY_EXISTS +
                    quizDto.getQuizName());
        }
        Quiz quiz = this.dtoToQuiz(quizDto);
        Category category = categoryRepository.findById(quiz.getCategory()
                .getCategoryId()).orElseGet(() -> {
                    LOGGER.error("Category doesn't exist with id: {}",
                            quiz.getCategory().getCategoryId());
                    throw new ResourceNotFound(Message.CATEGORY_NOT_FOUND
                            + "id :" + quiz.getCategory().getCategoryId());
                });
        quiz.setCategory(category);
        quizRepository.save(quiz);
        return new SuccessResponse(HttpStatus.CREATED.value(),
                Message.QUIZ_CREATED_SUCCESSFULLY) ;
    }
    /**
     * Retrieves a list of all quizzes as QuizDto objects.
     * @return A List of QuizDto objects representing all quizzes.
     */
    @Override
    public final List<QuizDto> getAllQuiz() {
        List<Quiz> qz = quizRepository.findAll();
        List<QuizDto> quizDtos = qz.stream()
                .map(this::quizToDto)
                .collect(Collectors.toList());
        return quizDtos;
    }
    /**
     * Retrieves a quiz by its unique identifier.
     * @param quizId The ID of the quiz to retrieve.
     * @return The QuizDto representing the requested quiz.
     * @throws RuntimeException if the quiz with the specified ID is not found.
     */
    @Override
    public final QuizDto getQuizById(final long quizId) {
        Optional<Quiz> quizfound = quizRepository
                .findById(quizId);
        if (quizfound.isPresent()) {
            Quiz quiz = quizfound.get();
            QuizDto quizDto = this.quizToDto(quiz);
            return quizDto;
        } else {
            LOGGER.error(Message.QUIZ_NOT_FOUND + quizId);
            throw new ResourceNotFound(
                    Message.QUIZ_NOT_FOUND + quizId);
        }
    }
    /**
     * Updates an existing quiz using the provided QuizDto and quiz ID.
     * @param quizId  The ID of the quiz to update.
     * @param quizDto The QuizDto containing updated quiz information.
     * @return A message indicating the success of the update operation.
     */
    @Override
    public final SuccessResponse updateQuiz(final long quizId,
            final QuizDto quizDto) {
        Quiz quiz = this.dtoToQuiz(quizDto);
        quiz.setQuizId(quizId);
        quizRepository.save(quiz);
        return new SuccessResponse(HttpStatus.OK.value(),
                Message.QUIZ_UPDATED_SUCCESSFULLY);
    }
    /**
     * Deletes a quiz by its unique identifier.
     * @param quizId The ID of the quiz to delete.
     */
    @Override
    public final SuccessResponse deleteQuiz(final long quizId) {
        quizRepository.deleteById(quizId);
        return new SuccessResponse(HttpStatus.NO_CONTENT.value(),
                Message.QUIZ_DELETED_SUCCESSFULLY);
    }
    /**
     * Converts a quiz entity to its corresponding DTO.
     * @param quiz The Quiz entity.
     * @return The corresponding QuizDto.
     */
    public final QuizDto quizToDto(final Quiz quiz) {
        QuizDto quizDto = modelMapper.map(quiz, QuizDto.class);
        if (quiz.getCategory() != null) {
            CategoryDto categoryDto = modelMapper.map(quiz.getCategory(),
                    CategoryDto.class);
            quizDto.setCategory(categoryDto);
        }
        return quizDto;
    }
    /**
     * Converts a QuizDto to its corresponding entity.
     * @param quizDto The QuizDto.
     * @return The corresponding Quiz entity.
     */
    public final Quiz dtoToQuiz(final QuizDto quizDto) {
        Quiz quiz = this.modelMapper.map(quizDto, Quiz.class);
        if (quizDto.getCategory() != null) {
            Category category = modelMapper.map(quizDto.getCategory(),
                    Category.class);
            quiz.setCategory(category);
        }
        return quiz;
    }
    /**
     * Converts a quizDTO to a quiz entity.
     * @param quizId To find the questions.
     * @return The list of question entity.
     */
    @Override
    public final List<QuestionDto> getAllQuestionByQuiz(final long quizId) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
        List<Question> questions = optionalQuiz.get().getQuestion();
        List<QuestionDto> questionDtos = questions.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return questionDtos;
    }
    /**
     * @param question The object to be converted.
     * @return the converted into QuestionDto entity.
     */
    private QuestionDto convertEntityToDto(final Question question) {

        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionId(question.getQuestionId());
        questionDto.setQuestionName(question.getQuestionName());
        Options options = new Options(question.getOptionOne(),
                question.getOptionTwo(), question.getOptionThree(),
                question.getOptionFour());
        questionDto.setOptions(options);
        questionDto.setAnswer(question.getAnswer());
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(
                question.getQuiz().getCategory().getCategoryId());
        categoryDto.setCategoryName(
                question.getQuiz().getCategory().getCategoryName());
        categoryDto.setDescription(
                question.getQuiz().getCategory().getDescription());

        QuizDto quizDto = new QuizDto();
        quizDto.setQuizId(question.getQuiz().getQuizId());
        quizDto.setQuizName(question.getQuiz().getQuizName());
        quizDto.setQuizDescription(question.getQuiz().getQuizDescription());
        quizDto.setTime(question.getQuiz().getTime());
        quizDto.setCategory(categoryDto);

        questionDto.setQuiz(quizDto);

        return questionDto;
    }
}
