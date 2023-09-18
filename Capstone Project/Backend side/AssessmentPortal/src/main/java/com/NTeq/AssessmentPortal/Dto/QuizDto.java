package com.NTeq.AssessmentPortal.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) class representing a Quiz's information.
 */
@Getter
@Setter
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
    /**
     * Constructs a new QuizDto object with the specified parameters.
     * @param quizzId          The unique identifier for the quiz.
     * @param quizzName        The name of the quiz.
     * @param quizzDescription A description of the quiz.
     * @param cat             The CategoryDto associated with the quiz.
     * @param qtime            The duration of the quiz in minutes.
     */
    public QuizDto(final long quizzId, final String quizzName,
            final String quizzDescription, final CategoryDto cat,
            final int qtime) {
        super();
        this.quizId = quizzId;
        this.quizName = quizzName;
        this.quizDescription = quizzDescription;
        if (cat != null) {
            this.category = new CategoryDto(cat.getCategoryId(),
                    cat.getCategoryName(), cat.getDescription());
            } else {
                this.category = null;
            }
        this.time = qtime;
    }
    /**
     * Getter for getting category.
     * @return CategoryDTO object.
     */
    public final CategoryDto getCategory() {
        if (category != null) {
        return new CategoryDto(category.getCategoryId(),
                category.getCategoryName(),
                category.getDescription());
        }
        return null;
    }
    /**
     * Setting category.
     * @param paramCategory CategoryDTO object.
     */
    public final void setCategory(final CategoryDto paramCategory) {
        if (paramCategory != null) {
        this.category = new CategoryDto(paramCategory.getCategoryId(),
             paramCategory.getCategoryName(), paramCategory.getDescription());
        } else {
            this.category = null;
        }
    }
}
