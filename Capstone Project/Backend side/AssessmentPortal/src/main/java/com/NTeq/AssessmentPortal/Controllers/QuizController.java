package com.NTeq.AssessmentPortal.Controllers;

import java.util.List;
import java.util.Optional;

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
import com.NTeq.AssessmentPortal.Dto.QuizDto;
import com.NTeq.AssessmentPortal.Services.impl.QuizServiceImpl;

/**
 * Controller class that handles HTTP requests related to Quiz operations.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/quiz")
public class QuizController {
    /**
     * The QuizService implementation that handles quiz operations.
     * This field is automatically injected by the @Autowired annotation.
     */
    @Autowired
    private QuizServiceImpl quizService;
    /**
     * End point to add a new quiz.
     * @param qzDto The Quiz DTO containing quiz details.
     * @return A message indicating the addition status.
     */
    @PostMapping("/addQuiz")
    public final String saveQuiz(final @RequestBody QuizDto qzDto) {
        return quizService.addQuiz(qzDto);
    }
    /**
     * End point to retrieve a Quiz by ID.
     * @param id The ID of the Quiz to retrieve.
     * @return The ResponseEntity containing the Quiz DTO if found,
     * NOT_FOUND,status if not found.
     */
    @GetMapping("/getQuiz/{id}")
    public final ResponseEntity<QuizDto> getCategory(
           final @PathVariable("id") long id) {
        QuizDto qz = quizService.getQuizById(id);
        if (qz == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(qz));
    }
    /**
     * End point to retrieve a list of all Quizzes.
     * @return A list of Quiz DTOs.
     */
    @GetMapping("/all")
    public final List<QuizDto> getAll() {
        return quizService.getAllQuiz();
    }
    /**
     * End point to update a quiz by ID.
     * @param id    The ID of the quiz to update.
     * @param qzDto The updated quiz DTO.
     * @return The ResponseEntity containing the updated quiz DTO if
     *      successful,or INTERNAL_SERVER_ERROR status if an exception occurs.
     */
    @PutMapping("/update/{id}")
    public final ResponseEntity<QuizDto> updateQuiz(final
        @PathVariable("id") long id, final @RequestBody QuizDto qzDto) {
        try {
            quizService.updateQuiz(id, qzDto);
            return ResponseEntity.ok().body(qzDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR))
                    .build();
        }
    }
    /**
     * End point to delete a quiz by ID.
     * @param id The ID of the quiz to delete.
     * @return The ResponseEntity indicating success with NO_CONTENT status
     *         INTERNAL_SERVER_ERROR status if an exception occurs.
     */
    @DeleteMapping("/delete/{id}")
    public final ResponseEntity<Void> deleteQuiz(final @PathVariable("id")
                                                       long id) {
        try {
            quizService.deleteQuiz(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR))
                    .build();
        }
    }
}
