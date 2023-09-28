package com.NTeq.AssessmentPortal.Services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NTeq.AssessmentPortal.Dto.CategoryDto;
import com.NTeq.AssessmentPortal.Dto.QuestionDto;
import com.NTeq.AssessmentPortal.Dto.QuizDto;
import com.NTeq.AssessmentPortal.Entity.Category;
import com.NTeq.AssessmentPortal.Entity.Options;
import com.NTeq.AssessmentPortal.Entity.Question;
import com.NTeq.AssessmentPortal.Entity.Quiz;
import com.NTeq.AssessmentPortal.Exceptions.ResourceNotFound;
import com.NTeq.AssessmentPortal.Repositories.QuestionRepository;
import com.NTeq.AssessmentPortal.Services.QuestionService;
/**
 * Service implementation for managing Question-related operations.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    private final Logger LOGGER = LoggerFactory
            .getLogger(QuestionServiceImpl.class);
    /**
     * Repository for question data. Injected by Spring using @Autowired.
     */
    @Autowired
    private QuestionRepository questionRepository;
    /**
     * Adds a new question using the provided QuestionDto.
     * @param questionDto The QuestionDto containing question information.
     * @return A message indicating the success of the operation.
     */
    @Override
    public final String addQuestion(final QuestionDto questionDto) {
        LOGGER.info("Adding a new question");
        Question question = this.dtoToQuestion(questionDto);
        String correctOption = question.getAnswer();
        if(!(correctOption.equalsIgnoreCase(question.getOptionOne())
             || correctOption.equalsIgnoreCase(question.getOptionTwo())
             || correctOption.equalsIgnoreCase(question.getOptionThree())
             || correctOption.equalsIgnoreCase(question.getOptionFour())))
        {
            LOGGER.error("Answer doesn't match with options for question ");
            throw new ResourceNotFound("Answer doesn't match with options");
        }
        questionRepository.save(question);
        LOGGER.info("Question added successfully");
        return "Question added successfully";
    }
    /**
     * Retrieves a list of all questions as QuestionDto objects.
     * @return A List of QuestionDto objects representing all questions.
     */
    @Override
    public final List<QuestionDto> getAllQuestion() {
        LOGGER.info("Getting all questions");

        List<Question> questions = questionRepository.findAll();
        List<QuestionDto> questionDtos = questions.stream()
                .map(this::questionToDto)
                .collect(Collectors.toList());

        LOGGER.info("Retrieved {} questions", questionDtos.size());
        return questionDtos;
    }
    /**
     * Retrieves a question by its unique identifier.
     * @param questionId The ID of the question to retrieve.
     * @return The QuestionDto representing the requested question
     *  or null if not found.
     */
    @Override
    public final QuestionDto getQuestionById(final long questionId) {
        LOGGER.info("Getting question by ID: {}", questionId);
        Question question = questionRepository.findById(questionId)
                .orElse(null);
        if (question != null) {
            QuestionDto questionDto = this.questionToDto(question);

            LOGGER.info("Retrieved question: {}", questionDto.getQuestionName());
            return questionDto;
        }
        LOGGER.warn("Question not found for ID: {}", questionId);
        return null;
    }
    /**
     * Updates an existing question using the QuestionDto and question ID.
     * @param questionId  The ID of the question to update.
     * @param questionDto The QuestionDto containing updated question info.
     * @return A message indicating the success of the update operation or
     *  "Question not found" if the question doesn't exist.
     */
    @Override
    public final String updateQuestion(final long questionId,
            final QuestionDto questionDto) {
        LOGGER.info("Updating question with ID: {}", questionId);
        Question existingQuestion = questionRepository.findById(questionId)
                .orElse(null);
        if (existingQuestion != null) {
            Question updatedQuestion = this.dtoToQuestion(questionDto);
            updatedQuestion.setQuestionId(questionId);
            questionRepository.save(updatedQuestion);
            LOGGER.info("Question updated successfully");
            return "Question updated successfully";
        }
        LOGGER.warn("Question not found for ID: {}", questionId);
        return "Question not found";
    }
    /**
     * Deletes a question by its unique identifier.
     * @param questionId The ID of the question to delete.
     */
    @Override
    public final void deleteQuestion(final long questionId) {
        LOGGER.info("Deleting question by ID: {}", questionId);
        questionRepository.deleteById(questionId);
        LOGGER.info("Question deleted successfully");
      }
    /**
     * Converts a QuestionDto object to a Question entity.
     * @param questionDto The QuestionDto object to be converted.
     * @return The corresponding Question entity.
     */
    public final Question dtoToQuestion(final QuestionDto questionDto) {
        Question question = new Question();
        question.setQuestionId(questionDto.getQuestionId());
        question.setQuestionName(questionDto.getQuestionName());
        question.setOptionOne(questionDto.getOptions().getOptionOne());
        question.setOptionTwo(questionDto.getOptions().getOptionTwo());
        question.setOptionThree(questionDto.getOptions().getOptionThree());
        question.setOptionFour(questionDto.getOptions().getOptionFour());
        question.setAnswer(questionDto.getAnswer());
        Category category = new Category();
        category.setCategoryId(
                questionDto.getQuiz().getCategory().getCategoryId());
        category.setCategoryName(questionDto.getQuiz().
                getCategory().getCategoryName());
        category.setDescription(
                questionDto.getQuiz().getCategory().getDescription());
        Quiz quiz = new Quiz(questionDto.getQuiz().getQuizId(),
                questionDto.getQuiz().getQuizName(),
                questionDto.getQuiz().getQuizDescription(),
                category,
                questionDto.getQuiz().getTime());
        quiz.setCategory(category);
        question.setQuiz(quiz);
        return question;
      }
    /**
     * Converts a Question entity to a QuestionDto object.
     * @param question The Question entity to be converted.
     * @return The corresponding QuestionDto object.
     */
    public final QuestionDto questionToDto(final Question question) {
       QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionId(question.getQuestionId());
        questionDto.setQuestionName(question.getQuestionName());
        Options options = new Options(question.getOptionOne(),
                question.getOptionTwo(), question.getOptionThree(),
                question.getOptionFour());
        questionDto.setOptions(options);
        questionDto.setAnswer(question.getAnswer());
        CategoryDto categoryDto = new CategoryDto(
                question.getQuiz().getCategory().getCategoryId(),
                question.getQuiz().getCategory().getCategoryName(),
                question.getQuiz().getCategory().getDescription());
        QuizDto quizDTO = new QuizDto(question.getQuiz().getQuizId(),
                question.getQuiz().getQuizName(),
                question.getQuiz().getQuizDescription(),
                categoryDto, question.getQuiz().getTime());
        questionDto.setQuiz(quizDTO);
        return questionDto;
      }
}

