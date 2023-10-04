package com.NTeq.AssessmentPortal.Services;

import java.util.List;

import com.NTeq.AssessmentPortal.Dto.QuestionDto;
import com.NTeq.AssessmentPortal.Response.SuccessResponse;

/**
 * Service interface for managing Question-related operations.
 */
public interface QuestionService {
    /**
     * Adds a new question to the system.
     * @param questionDto The DTO containing question details.
     * @return A message indicating the result of the operation.
     */
    SuccessResponse addQuestion(QuestionDto questionDto);
    /**
     * Retrieves a question by its unique identifier.
     * @param questionId The ID of the question to retrieve.
     * @return The DTO representing the retrieved Question.
     */
    QuestionDto getQuestionById(long questionId);
    /**
     * Retrieves a list of all quizzes.
     * @return A list of quiz DTOs.
     */
    List<QuestionDto> getAllQuestion();
    /**
     * Updates a question's information.
     * @param questionId The ID of the question to update.
     * @param questionDto      The DTO containing updated question details.
     * @return A message indicating the result of the operation.
     */
    SuccessResponse updateQuestion(long questionId, QuestionDto questionDto);
    /**
     * Deletes a question by its unique identifier.
     * @param questionId The ID of the question to delete.
     * @return A message indicating the delete questions.
     */
    SuccessResponse deleteQuestion(long questionId);
}
