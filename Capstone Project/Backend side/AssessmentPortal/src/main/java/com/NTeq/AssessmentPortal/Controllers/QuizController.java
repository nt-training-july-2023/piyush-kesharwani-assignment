package com.NTeq.AssessmentPortal.Controllers;

import java.util.List;
import java.util.Optional;

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
import com.NTeq.AssessmentPortal.Dto.QuizDto;
import com.NTeq.AssessmentPortal.Response.Message;
import com.NTeq.AssessmentPortal.Response.SuccessResponse;
import com.NTeq.AssessmentPortal.Services.impl.QuizServiceImpl;

import jakarta.validation.Valid;

/**
 * Controller class that handles HTTP requests related to Quiz operations.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/quiz")
public class QuizController {
    /**
     * This class represents a logger for the QuizController.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(QuizController.class);
    /**
     * The QuizService implementation that handles quiz operations.
     * This field is automatically injected by the @Autowired annotation.
     */
    @Autowired
    private QuizServiceImpl quizService;
    /**
     * End point to add a new quiz.
     * @param quizDto The Quiz DTO containing quiz details.
     * @return A message indicating the addition status.
     */
    @PostMapping("/addQuiz")
    public final ResponseEntity<SuccessResponse> saveQuiz(@Valid final
            @RequestBody QuizDto quizDto) {
        LOGGER.info(Message.ADD_QUIZ);
        SuccessResponse result =  quizService.addQuiz(quizDto);
        LOGGER.info(Message.QUIZ_CREATED_SUCCESSFULLY);
        return new ResponseEntity<SuccessResponse>(result,
                HttpStatus.CREATED);
    }
    /**
     * End point to retrieve a Quiz by ID.
     * @param id The ID of the Quiz to retrieve.
     * @return The ResponseEntity containing the Quiz DTO if found,
     * NOT_FOUND,status if not found.
     */
    @GetMapping("/getQuiz/{id}")
    public final ResponseEntity<QuizDto> getQuiz(
           final @PathVariable("id") long id) {
        LOGGER.info(Message.GET_QUIZ_BY_ID, id);
        QuizDto quizDto = quizService.getQuizById(id);
        LOGGER.info(Message.GET_QUIZ_SUCESSFULLY, id);
        return ResponseEntity.of(Optional.of(quizDto));
    }
    /**
     * End point to retrieve a list of all Quizzes.
     * @return A list of Quiz DTOs.
     */
    @GetMapping("/all")
    public final List<QuizDto> getAll() {
        LOGGER.info(Message.GET_QUIZZES);
        List<QuizDto> quizzes = quizService.getAllQuiz();
        LOGGER.info(Message.RETRIVED_QUIZZES);
        return quizzes;
    }
    /**
     * End point to update a quiz by ID.
     * @param id    The ID of the quiz to update.
     * @param quizDto The updated quiz DTO.
     * @return The ResponseEntity containing the updated quiz DTO if
     *      successful,or INTERNAL_SERVER_ERROR status if an exception occurs.
     */
    @PutMapping("/update/{id}")
    public final ResponseEntity<SuccessResponse> updateQuiz(final
       @PathVariable("id") long id, @Valid final @RequestBody QuizDto quizDto) {
        LOGGER.info(Message.UPDATE_QUIZ, id);
      SuccessResponse response = quizService.updateQuiz(id, quizDto);
        LOGGER.info(Message.QUIZ_UPDATED_SUCCESSFULLY);
            return new ResponseEntity<SuccessResponse>(response,
                    HttpStatus.OK);
    }
    /**
     * End point to delete a quiz by ID.
     * @param id The ID of the quiz to delete.
     * @return The ResponseEntity indicating success with NO_CONTENT status
     *         INTERNAL_SERVER_ERROR status if an exception occurs.
     */
    @DeleteMapping("/delete/{id}")
    public final ResponseEntity<SuccessResponse> deleteQuiz(final
            @PathVariable("id") long id) {
           LOGGER.info(Message.DELETE_QUIZ, id);
           SuccessResponse response = quizService.deleteQuiz(id);
            LOGGER.info(Message.QUIZ_DELETED_SUCCESSFULLY);
            return new ResponseEntity<SuccessResponse>(response,
                    HttpStatus.OK);
    }
    /**
     * Retrieves a category by its ID.
     * @param quizId The ID of the category to retrieve.
     * @return The list of questions entity.
     */
    @GetMapping("/questions/{quizId}")
    public final List<QuestionDto> getAllQuestionByQuiz(
            @PathVariable final int quizId) {
        LOGGER.info(Message.GET_QUESTION_BY_QUIZ, quizId);
        List<QuestionDto> questionByQuiz = quizService
                .getAllQuestionByQuiz(quizId);
        LOGGER.info(Message.RETRIVED_QUESTION_BY_QUIZ, quizId);
        return questionByQuiz;
    }
}
