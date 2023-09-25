package com.NTeq.AssessmentPortal.Services;

import java.util.List;

import com.NTeq.AssessmentPortal.Dto.QuestionDto;
import com.NTeq.AssessmentPortal.Dto.QuizDto;
/**
 * Service interface for managing Quiz-related operations.
 */
public interface QuizService {
    /**
     * Adds a new quiz to the system.
     * @param quizDto The DTO containing quiz details.
     * @return A message indicating the result of the operation.
     */
    String addQuiz(QuizDto quizDto);
    /**
     * Retrieves a list of all quizzes.
     * @return A list of quiz DTOs.
     */
    List<QuizDto> getAllQuiz();
    /**
     * Retrieves a quiz by its unique identifier.
     * @param quizId The ID of the quiz to retrieve.
     * @return The DTO representing the retrieved category.
     */
    QuizDto getQuizById(long quizId);
    /**
     * Updates a quizzes's information.
     * @param quizId The ID of the quiz to update.
     * @param quizDto      The DTO containing updated quiz details.
     * @return A message indicating the result of the operation.
     */
    String updateQuiz(long quizId, QuizDto quizDto);
    /**
     * Deletes a quiz by its unique identifier.
     * @param quizId The ID of the quiz to delete.
     */
    void deleteQuiz(long quizId);
    /**
     * Retrieves a list of question associated with a specific Quiz.
     * @param quizId The quizId from questions are to be retrieved.
     * @return A list of question objects associated with the specified quiz.
     */
    List<QuestionDto> getAllQuestionByQuiz(long quizId);
}
