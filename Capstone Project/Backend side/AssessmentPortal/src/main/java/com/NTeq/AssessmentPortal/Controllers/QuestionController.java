package com.NTeq.AssessmentPortal.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NTeq.AssessmentPortal.Dto.QuestionDto;
import com.NTeq.AssessmentPortal.Response.Message;
import com.NTeq.AssessmentPortal.Response.SuccessResponse;
import com.NTeq.AssessmentPortal.Services.impl.QuestionServiceImpl;

import jakarta.validation.Valid;
/**
 * Controller class for managing questions-related operations.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/question")
public class QuestionController {
    /**
     * This class represents a logger for the QuestionController.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(QuestionController.class);
    /**
     * The QuestionService implementation that handles quiz operations.
     * This field is automatically injected by the @Autowired annotation.
     */
    @Autowired
    private QuestionServiceImpl questionService;
    /**
     * Adds a new question using the provided QuestionDto.
     * @param questionDto The QuestionDto containing question information.
     * @return A ResponseEntity indicating the success of the operation.
     */
    @PostMapping("/add")
    public final ResponseEntity<SuccessResponse> addQuestion(
           @Valid final @RequestBody QuestionDto questionDto) {
        LOGGER.info(Message.ADD_QUESTION);
        SuccessResponse result = questionService.addQuestion(questionDto);
        LOGGER.info(Message.QUESTION_CREATED_SUCCESSFULLY);
        return new ResponseEntity<SuccessResponse>(result, HttpStatus.CREATED);
    }
    /**
     * Retrieves a list of all questions as QuestionDto objects.
     * @return A List of QuestionDto objects representing all questions.
     */
    @GetMapping("/all")
    public final List<QuestionDto> getAll() {
        LOGGER.info(Message.GET_QUESTIONS);
        List<QuestionDto> questions = questionService.getAllQuestion();
        LOGGER.info(Message.RETRIVED_QUESTIONS);
        return questions;
    }
    /**
     * Retrieves a question by its unique identifier.
     * @param questionId The ID of the question to retrieve.
     * @return A ResponseEntity containing the QuestionDto representing
     *    the requested question.
     */
    @GetMapping("/{questionId}")
    public final ResponseEntity<QuestionDto> getQuestionById(
            final @PathVariable long questionId) {
       LOGGER.info(Message.GET_QUESTION_BY_ID, questionId);
        QuestionDto question = questionService.getQuestionById(questionId);
        LOGGER.info(Message.RETRIVED_QUESTIONS, questionId);
          return new ResponseEntity<>(question, HttpStatus.OK);
    }
    /**
     * Updates an existing question using the provided QuestionDto,question ID.
     * @param questionId The ID of the question to update.
     * @param questionDto The QuestionDto containing updated question.
     * @return A ResponseEntity indicating the success of the update operation.
     */
    @PutMapping("/update/{questionId}")
    public final ResponseEntity<SuccessResponse> updateQuestion(
           final @PathVariable long questionId,
          @Valid final @RequestBody QuestionDto questionDto) {
          LOGGER.info(Message.UPDATE_QUESTION, questionId);
           SuccessResponse response = questionService.updateQuestion(
                   questionId, questionDto);
            LOGGER.info(Message.QUESTION_UPDATED_SUCCESSFULLY);
            return new ResponseEntity<SuccessResponse>(response,
                    HttpStatus.OK);
    }
    /**
     * Deletes a question by its unique identifier.
     * @param questionId The ID of the question to delete.
     * @return A ResponseEntity indicating the success of the delete operation.
     */
    @DeleteMapping("/{questionId}")
    public final ResponseEntity<SuccessResponse> deleteQuestion(
            final @PathVariable long questionId) {
        LOGGER.info(Message.DELETE_QUESTION, questionId);
        SuccessResponse response = questionService.deleteQuestion(questionId);
        LOGGER.info(Message.QUESTION_DELETED_SUCCESSFULLY);
        return new ResponseEntity<SuccessResponse>(response,
                HttpStatus.OK);
    }
}
