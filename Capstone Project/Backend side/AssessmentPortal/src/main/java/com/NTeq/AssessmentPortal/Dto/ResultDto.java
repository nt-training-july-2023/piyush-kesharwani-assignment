package com.NTeq.AssessmentPortal.Dto;

import java.util.Objects;

import jakarta.validation.constraints.Min;
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
    @Min(value = 1, message = "Minimun value should be 1")
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
    @Min(value = 1, message = "Minimun value should be 1")
    private int totalQuestion;
    /**
     * Generates a hash code for this ResultDto object.
     * @return The hash code value based on attemptedQuestion,
     *  categoryName, dateTime, obtainedMarks, quizName, resultId,
     *  totalMarks, totalQuestion, userEmail, and userName properties.
     */
    @Override
    public int hashCode() {
        return Objects.hash(attemptedQuestion, categoryName, dateTime,
                obtainedMarks, quizName, resultId, totalMarks, totalQuestion,
                userEmail, userName);
    }
    /**
     * Checks if this ResultDto object is equal to another object.
     * @param obj The object to compare with.
     * @return {@code true} if objects are equal based on attemptedQuestion,
     *  categoryName, dateTime, obtainedMarks, quizName, resultId,
     *  totalMarks, totalQuestion, userEmail, and userName properties,
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ResultDto other = (ResultDto) obj;
        return attemptedQuestion == other.attemptedQuestion
                && Objects.equals(categoryName, other.categoryName)
                && Objects.equals(dateTime, other.dateTime)
                && obtainedMarks == other.obtainedMarks
                && Objects.equals(quizName, other.quizName)
                && resultId == other.resultId && totalMarks == other.totalMarks
                && totalQuestion == other.totalQuestion
                && Objects.equals(userEmail, other.userEmail)
                && Objects.equals(userName, other.userName);
    }
}
