package com.NTeq.AssessmentPortal.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Data Transfer Object (DTO) representing the result of a quiz assessment.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {
    /**
     * The unique identifier for the result.
     */
    private long resultId;
    /**
     * The total marks available for the assessment.
     */
    @NotNull(message = "Total marks is required")
    private int totalMarks;
    /**
     * The marks obtained by the user in the assessment.
     */
    @NotNull(message = "Obtained marks is required")
    private int obtainedMarks;
    /**
     * The email address of the user who took the assessment.
     */
    @NotBlank(message = "Email is required")
    private String userEmail;
    /**
     * The name of the user who took the assessment.
     */
    @NotBlank(message = "Name is required")
    private String userName;
    /**
     * The date and time when the assessment was taken.
     */
    @NotBlank(message = "Date and Time is required")
    private String dateTime;
    /**
     * The name of the quiz for which the assessment was taken.
     */
    @NotBlank(message = "Quiz Name is required")
    private String quizName;
    /**
     * The name of the quiz for which the assessment was taken.
     */
    @NotBlank(message = "Category is required")
    private String categoryName;
    /**
     * The number of questions attempted in the assessment.
     */
    @NotNull(message = "attempted question is required")
    private int attemptedQuestion;
    /**
     * The total number of questions in the assessment.
     */
    @NotNull(message = "Total marks is required")
    private int totalQuestion;
}
