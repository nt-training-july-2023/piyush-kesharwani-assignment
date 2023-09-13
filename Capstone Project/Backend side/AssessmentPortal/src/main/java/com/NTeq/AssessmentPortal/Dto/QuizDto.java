package com.NTeq.AssessmentPortal.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) class representing a Quiz's information.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    /**
     * The ID of the Quiz.
     */
    private long quizId;
    /**
     * The name of the quiz.
     */
    private String quizName;
    /**
     * The description of the Quiz.
     */
    private String quizDescription;
    /**
     * The object of the category.
     */
    private CategoryDto category;
    /**
     * The time of the Quiz.
     */
    private int time;

}
