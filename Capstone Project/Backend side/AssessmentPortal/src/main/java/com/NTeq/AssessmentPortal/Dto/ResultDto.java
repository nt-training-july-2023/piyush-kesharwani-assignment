package com.NTeq.AssessmentPortal.Dto;

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
    private int totalMarks;
    /**
     * The marks obtained by the user in the assessment.
     */
    private int obtainedMarks;
    /**
     * The email address of the user who took the assessment.
     */
    private String userEmail;
    /**
     * The name of the user who took the assessment.
     */
    private String userName;
    /**
     * The date and time when the assessment was taken.
     */
    private String dateTime;
    /**
     * The name of the quiz for which the assessment was taken.
     */
    private String quizName;
    /**
     * The name of the quiz for which the assessment was taken.
     */
    private String categoryName;
    /**
     * The number of questions attempted in the assessment.
     */
    private int attemptedQuestion;
    /**
     * The total number of questions in the assessment.
     */
    private int totalQuestion;
}
