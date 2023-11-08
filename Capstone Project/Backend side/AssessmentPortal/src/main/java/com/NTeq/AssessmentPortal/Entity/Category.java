package com.NTeq.AssessmentPortal.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing a category in the application.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {
    /**
     * The unique ID of the category.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;
    /**
     * The name of the category.
     */
    @Column(nullable = false)
    private String categoryName;
    /**
     * The description of the category.
     */
    @Column(nullable = false)
    private String description;
    /**
     * A list of quizzes associated with this category.
     * This field represents a one-to-many relationship with the Quiz entities.
     * The '@JsonIgnore' annotation prevents the JSON serialization of this
     * field to avoid circular references and potential infinite loops
     * when serializing to JSON.
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Quiz> quiz = new ArrayList<>();
    /**
     * Get the list of quizzes associated with this category.
     * @return A list of quizzes.
     */
    public final List<Quiz> getQuiz() {
        return new ArrayList<>(quiz);
    }
    /**
     * Set the list of quizzes associated with this category.
     * @param qz The new list of quizzes.
     */
    public final void setQuiz(final List<Quiz> qz) {
        this.quiz = new ArrayList<>(qz);
    }
    /**
     * parameter constructor for category.
     * @param catId categoryId.
     * @param catName categoryName.
     * @param catdescription description.
     */
    public Category(final long catId,
            final String catName,
            final String catdescription) {
        this.categoryId = catId;
        this.categoryName = catName;
        this.description = catdescription;
    }

}
