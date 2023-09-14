package com.NTeq.AssessmentPortal.Services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NTeq.AssessmentPortal.Dto.CategoryDto;
import com.NTeq.AssessmentPortal.Dto.QuestionDto;
import com.NTeq.AssessmentPortal.Dto.QuizDto;
import com.NTeq.AssessmentPortal.Entity.Category;
import com.NTeq.AssessmentPortal.Entity.Question;
import com.NTeq.AssessmentPortal.Entity.Quiz;
import com.NTeq.AssessmentPortal.Repositories.QuestionRepository;
import com.NTeq.AssessmentPortal.Services.QuestionService;
/**
 * Service implementation for managing Question-related operations.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    /**
     * Repository for question data. Injected by Spring using @Autowired.
     */
    @Autowired
    QuestionRepository questionRepository;
    /**
     * Adds a new question using the provided QuestionDto.
     * @param questionDto The QuestionDto containing question information.
     * @return A message indicating the success of the operation.
     */
    @Override
    public String addQuestion(final QuestionDto questionDto) {
        Question question = this.dtoToQuestion(questionDto);
        questionRepository.save(question);
        return "Question added successfully";
    }
    /**
     * Retrieves a list of all questions as QuestionDto objects.
     * @return A List of QuestionDto objects representing all questions.
     */
    @Override
    public List<QuestionDto> getAllQuestion() {
        List<Question> question = questionRepository.findAll();
        return question.stream()
                .map(this::questionToDto)
                .collect(Collectors.toList());
    }
    /**
     * Retrieves a question by its unique identifier.
     * @param questionId The ID of the question to retrieve.
     * @return The QuestionDto representing the requested question
     *  or null if not found.
     */
    @Override
    public QuestionDto getQuestionById(final long questionId) {
        Question question = questionRepository.findById(questionId).orElse(null);
        if (question != null) {
            return questionToDto(question);
        }
        return null;
    }
    /**
     * Updates an existing question using the QuestionDto and question ID.
     * @param questionId  The ID of the question to update.
     * @param questionDto The QuestionDto containing updated question information.
     * @return A message indicating the success of the update operation or
     *  "Question not found" if the question doesn't exist.
     */
    @Override
    public String updateQuestion(final long questionId, 
            final QuestionDto questionDto) {
        Question existingQuestion = questionRepository.findById(questionId)
                .orElse(null);
        if (existingQuestion != null) {
            Question updatedQuestion = this.dtoToQuestion(questionDto);
            updatedQuestion.setQuestionId(questionId);
            questionRepository.save(updatedQuestion);
            return "Question updated successfully";
        }
        return "Question not found";
    }
    /**
     * Deletes a question by its unique identifier.
     * @param questionId The ID of the question to delete.
     */
    @Override
    public void deleteQuestion(final long questionId) {
        questionRepository.deleteById(questionId);
      }
    /**
     * Converts a QuestionDto object to a Question entity.
     * @param questionDto The QuestionDto object to be converted.
     * @return The corresponding Question entity.
     */
    private Question dtoToQuestion(final QuestionDto questionDto) {
        Question question = new Question();
        question.setQuestionId(questionDto.getQuestionId());
        question.setQuestionName(questionDto.getQuestionName());
        question.setOptionOne(questionDto.getOptionOne());
        question.setOptionTwo(questionDto.getOptionTwo());
        question.setOptionThree(questionDto.getOptionThree());
        question.setOptionFour(questionDto.getOptionFour());
        question.setAnswer(questionDto.getAnswer());
        Category category = new Category();
        category.setCategoryId(
                questionDto.getQuiz().getCategory().getCategoryId());
        category.setCategoryName(questionDto.getQuiz().getCategory().getCategoryName());
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
    private QuestionDto questionToDto(final Question question) {
       QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionId(question.getQuestionId());
        questionDto.setQuestionName(question.getQuestionName());
        questionDto.setOptionOne(question.getOptionOne());
        questionDto.setOptionTwo(question.getOptionTwo());
        questionDto.setOptionThree(question.getOptionThree());
        questionDto.setOptionFour(question.getOptionFour());
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

