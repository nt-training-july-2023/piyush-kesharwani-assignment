package com.NTeq.AssessmentPortal.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing a quiz in the application.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Quiz {
    /**
     * The unique ID of the quiz.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long quizId;
    /**
     * The name of the quiz.
     */
    @Column(nullable = false)
    private String quizName;
    /**
     * The description of the quiz.
     */
    @Column(nullable = false)
    private String quizDescription;
    /**
     * The category associated with this entity.
     * This field represents a many-to-one relationship with Category entity.
     * It uses eager fetching to load the associated category when this entity
     * is retrieved. The 'categoryId' column in the database is used as the
     * foreign key to link to the Category entity.
     * @see Category
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;
    /**
     * The time of the quiz.
     */
    @Min(value = 1, message = "Minimun time should be of 1 min")
    private int time;
    /**
     * Represents a list of questions associated with a Quiz.
     */
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Question> question;
     /**
     * get category.
     * @return category.
     */
    public final Category getCategory() {
      if (category != null) {
       return new Category(category.getCategoryId(),
                category.getCategoryName(),
                category.getDescription());
        }
        return null;
    }
     /**
     * set Category.
     * @param cate cate.
     */
    public final void setCategory(final Category cate) {
        if (cate != null) {
        this.category = new Category(cate.getCategoryId(),
                cate.getCategoryName(), cate.getDescription());
        } else {
            this.category = null;
        }
    }
    /**
     * parameter constructor for Quiz.
     * @param qId          quizId.
     * @param qName        quizName.
     * @param qDescription quizDescription.
     * @param cat       Category Object.
     * @param qtime            time.
     */
    public Quiz(final long qId, final String qName,
            final String qDescription, final Category cat, final int qtime) {
        this.quizId = qId;
        this.quizName = qName;
        this.quizDescription = qDescription;
        this.category = new Category(cat.getCategoryId(),
                cat.getCategoryName(),
                cat.getDescription());
        this.time = qtime;
    }
    /**
     * Get the list of questions associated with this entity.
     * @return A new ArrayList containing the questions.
     */
    public final List<Question> getQuestion() {
        return new ArrayList<>(question);
    }
    /**
     * Set the list of questions associated with this entity.
     * Note: This method creates a new ArrayList based on the provided list
     * to avoid modifying the original list directly.
     * @param questions The list of questions to associate with this entity.
     */
    public final void setQuestion(final List<Question> questions) {
        this.question = new ArrayList<>(questions);
    }
}
