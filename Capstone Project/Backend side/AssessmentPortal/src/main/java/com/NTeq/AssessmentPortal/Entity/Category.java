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
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Quiz> quiz = new ArrayList<>();
    /**
     * get quiz.
     * @return quiz
     */
    public List<Quiz> getQuiz() {
        return new ArrayList<>(quiz);
    }
    /**
     * set quiz.
     * @param Quiz quiz.
     */
    public void setQuiz(final List<Quiz> quiz) {
        this.quiz = new ArrayList<>(quiz);
    }
    /**
     * parameter constructor for category.
     * @param categoryid categoryId.
     * @param categoryname categoryName.
     * @param categorydescription description.
     */
    public Category(final long categoryId,
            final String categoryName,
            final String description) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
    }

}
