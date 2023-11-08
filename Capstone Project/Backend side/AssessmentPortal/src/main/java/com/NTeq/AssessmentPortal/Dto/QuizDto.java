package com.NTeq.AssessmentPortal.Dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) class representing a Quiz's information.
 */
@Getter
@Setter
@NoArgsConstructor
@Validated
public class QuizDto {
    /**
     * The ID of the Quiz.
     */
    private long quizId;
    /**
     * The name of the quiz.
     */
    @NotBlank(message = "Quiz Name is required")
    private String quizName;
    /**
     * The description of the Quiz.
     */
    @NotBlank(message = "Quiz description is required")
    private String quizDescription;
    /**
     * The object of the category.
     */
    @NotNull(message = "Category is required")
    @Valid
    private CategoryDto category;
    /**
     * The time of the Quiz.
     */
    @Min(value = 1, message = "Minimun time should be of 1 min")
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
    /**
     * Generates a hash code for this QuizDto object.
     * @return The hash code value based on category,
     *  quizDescription, quizId, quizName, and time properties.
     */
    @Override
    public int hashCode() {
        return Objects.hash(category, quizDescription, quizId, quizName, time);
    }
    /**
     * Checks if this QuizDto object is equal to another object.
     * @param obj The object to compare with.
     * @return {@code true} if objects are equal based on category,
     *          quizDescription, quizId, quizName, and time properties,
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
        QuizDto other = (QuizDto) obj;
        return Objects.equals(category, other.category)
                && Objects.equals(quizDescription, other.quizDescription)
                && quizId == other.quizId
                && Objects.equals(quizName, other.quizName)
                && time == other.time;
    }
}
