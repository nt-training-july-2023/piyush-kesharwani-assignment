package com.NTeq.AssessmentPortal.Controllers;

import java.util.List;

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
        String result = questionService.addQuestion(questionDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    /**
     * Retrieves a list of all questions as QuestionDto objects.
     * @return A List of QuestionDto objects representing all questions.
     */
    @GetMapping("/all")
    public final List<QuestionDto> getAll() {
        return questionService.getAllQuestion();
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
        QuestionDto question = questionService.getQuestionById(questionId);
        if (question != null) {
            return new ResponseEntity<>(question, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
        try {
            questionService.updateQuestion(questionId, questionDto);
            return ResponseEntity.ok().body(questionDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR))
                    .build();
        }
    }
    /**
     * Deletes a question by its unique identifier.
     * @param questionId The ID of the question to delete.
     * @return A ResponseEntity indicating the success of the delete operation.
     */
    @DeleteMapping("/{questionId}")
    public final ResponseEntity<Void> deleteQuestion(
            final @PathVariable long questionId) {
        questionService.deleteQuestion(questionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
