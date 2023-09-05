package com.NTeq.AssessmentPortal.Services;

import java.util.List;
import com.NTeq.AssessmentPortal.Dto.QuizDto;

public interface QuizService {
    /**
     * Adds a new category to the system.
     * @param cgDto The DTO containing category details.
     * @return A message indicating the result of the operation.
     */
    String addQuiz(QuizDto quizDto);

    /**
     * Retrieves a list of all categories.
     * 
     * @return A list of category DTOs.
     */
    List<QuizDto> getAllQuiz();

    /**
     * Retrieves a category by its unique identifier.
     * 
     * @param categoryId The ID of the category to retrieve.
     * @return The DTO representing the retrieved category.
     */
    QuizDto getQuizById(long QuizId);

    /**
     * Updates a category's information.
     * 
     * @param categoryId The ID of the category to update.
     * @param cgDto      The DTO containing updated category details.
     * @return A message indicating the result of the operation.
     */
    String updateQuiz(long quizId, QuizDto quizDto);

    /**
     * Deletes a category by its unique identifier.
     * 
     * @param categoryId The ID of the category to delete.
     */
    void deleteQuiz(long quizId);
}
