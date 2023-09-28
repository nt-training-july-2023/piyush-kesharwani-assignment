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
import com.NTeq.AssessmentPortal.Services.impl.QuestionServiceImpl;

import jakarta.validation.Valid;
/**
 * Controller class for managing questions-related operations.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/question")
public class QuestionController {
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
    public final ResponseEntity<String> addQuestion(
           @Valid final @RequestBody QuestionDto questionDto) {
        LOGGER.info("Add Question Method invoked");
        String result = questionService.addQuestion(questionDto);
        LOGGER.info("Question added Successfully");
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    /**
     * Retrieves a list of all questions as QuestionDto objects.
     * @return A List of QuestionDto objects representing all questions.
     */
    @GetMapping("/all")
    public final List<QuestionDto> getAll() {
        LOGGER.info("Get Questions method invoke");
        List<QuestionDto> questions = questionService.getAllQuestion();
        LOGGER.info("Retrieved Questions successfully");
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
       LOGGER.info("Getting question with ID: {}",questionId);
        QuestionDto question = questionService.getQuestionById(questionId);
        LOGGER.info("successfully fetched Quiz with ID {}",questionId);
          return new ResponseEntity<>(question, HttpStatus.OK);
    }
    /**
     * Updates an existing question using the provided QuestionDto,question ID.
     * @param questionId The ID of the question to update.
     * @param questionDto The QuestionDto containing updated question.
     * @return A ResponseEntity indicating the success of the update operation.
     */
    @PutMapping("/update/{questionId}")
    public final ResponseEntity<QuestionDto> updateQuestion(
           final @PathVariable long questionId,
          @Valid final @RequestBody QuestionDto questionDto) {
          LOGGER.info("Updating question with ID: {}", questionId);  
            questionService.updateQuestion(questionId, questionDto);
            LOGGER.info("Question updated successfully");
            return ResponseEntity.ok().body(questionDto);
    }
    /**
     * Deletes a question by its unique identifier.
     * @param questionId The ID of the question to delete.
     * @return A ResponseEntity indicating the success of the delete operation.
     */
    @DeleteMapping("/{questionId}")
    public final ResponseEntity<Void> deleteQuestion(
            final @PathVariable long questionId) {
        LOGGER.info("Deleting question by ID: {}", questionId);
        questionService.deleteQuestion(questionId);
        LOGGER.info("Quiz deleted successfully");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
