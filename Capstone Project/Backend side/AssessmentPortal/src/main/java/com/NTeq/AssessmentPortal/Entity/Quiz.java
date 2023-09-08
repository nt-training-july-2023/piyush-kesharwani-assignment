package com.NTeq.AssessmentPortal.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @JoinColumn(name = "categoryId")
    private Category category;
    /**
     * The time of the quiz.
     */
    private int time;
     /**
     * get category.
     * @return category.
     */
    public final Category getCategory() {
        return category;
    }
     /**
     * set Category.
     * @param cate cate.
     */
    public final void setCategory(final Category cate) {
        this.category = new Category(cate.getCategoryId(),
                cate.getCategoryName(), cate.getDescription());
    }
    /**
     * parameter constructor for Quiz.
     * @param qId          quizId.
     * @param qName        quizName.
     * @param qDescription quizDescription.
     * @param qtime            time.
     */
    public Quiz(final long qId, final String qName,
            final String qDescription, final int qtime) {
        this.quizId = qId;
        this.quizName = qName;
        this.quizDescription = qDescription;
        this.time = qtime;
    }
}
