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
 * Entity class representing a question in the application.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Question {
    /**
     * The unique ID of the question.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long questionId;
    /**
     * The name of the question.
     */
    @Column(nullable = false)
    private String questionName;
    
    @Column(nullable = false)
    private String optionOne;
    /**
     * The first option of the question.
     */
    @Column(nullable = false)
    private String optionTwo;
    /**
     * The second option of the question.
     */
    @Column(nullable = false)
    private String optionThree;
    /**
     * The third option of the question.
     */
    @Column(nullable = false)
    private String optionFour;
    /**
     * The correct option of the question.
     */
    @Column(nullable = false)
    private String answer;
    /**
     * The associated Quiz to which this question belongs.
     * This relationship is fetched eagerly from the database.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quizId",nullable=false)
    private Quiz quiz;
    /**
     * Get the associated Quiz for this question.
     * @return The Quiz to which this question belongs.
     */
    public Quiz getQuiz() {
        return quiz;
    }
    /**
     * Set the associated Quiz for this question.
     * Note: This method creates a new Quiz instance based on the provided quiz
     *       to avoid modifying the original quiz object directly.
     * @param quiz The Quiz to associate with this question.
     */
    public void setQuiz(Quiz quiz) {
        this.quiz = new Quiz(quiz.getQuizId(),quiz.getQuizName()
                ,quiz.getQuizDescription(),quiz.getTime());
    }
    /**
     * Constructor to initialize a Question with its attributes.
     * @param questionId     The unique identifier for this question.
     * @param questionName   The name or text of the question.
     * @param optionOne      The first option for answering the question.
     * @param optionTwo      The second option for answering the question.
     * @param optionThree    The third option for answering the question.
     * @param optionFour     The fourth option for answering the question.
     * @param answer         The correct answer to the question.
     */
    public Question(long questionId, String questionName, String optionOne,
            String optionTwo, String optionThree, String optionFour,
            String answer) {
        super();
        this.questionId = questionId;
        this.questionName = questionName;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.answer = answer;
    }
}
