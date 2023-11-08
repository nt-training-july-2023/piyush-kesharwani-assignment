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
    /**
     * The first option of the question.
     */
    @Column(nullable = false)
    private String optionOne;
    /**
     * The second option of the question.
     */
    @Column(nullable = false)
    private String optionTwo;
    /**
     * The third option of the question.
     */
    @Column(nullable = false)
    private String optionThree;
    /**
     * The fourth option of the question.
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
    @JoinColumn(name = "quizId", nullable = false)
    private Quiz quiz;
    /**
     * Get the associated Quiz for this question.
     * @return The Quiz to which this question belongs.
     */
    public final Quiz getQuiz() {
        return new Quiz(quiz.getQuizId(), quiz.getQuizName(),
              quiz.getQuizDescription(), quiz.getCategory(), quiz.getTime());
    }
    /**
     * Set the associated Quiz for this question.
     * Note: This method creates a new Quiz instance based on the provided quiz
     *       to avoid modifying the original quiz object directly.
     * @param quizz The Quiz to associate with this question.
     */
    public final void setQuiz(final Quiz quizz) {
        this.quiz = new Quiz(quizz.getQuizId(), quizz.getQuizName(),
          quizz.getQuizDescription(), quizz.getCategory(), quizz.getTime());
    }
    /**
     * Constructor to initialize a Question with its attributes.
     * @param quizzes quiz.
     * @param qName   The name or text of the question.
     * @param optionI      The first option for answering the question.
     * @param optionII      The second option for answering the question.
     * @param optionIII    The third option for answering the question.
     * @param optionIV     The fourth option for answering the question.
     * @param answers         The correct answer to the question.
     */
    public Question(final String qName,
             final String optionI, final String optionII,
             final String optionIII, final String optionIV,
               final String answers, final Quiz quizzes) {
        super();
        this.questionName = qName;
        this.optionOne = optionI;
        this.optionTwo = optionII;
        this.optionThree = optionIII;
        this.optionFour = optionIV;
        this.answer = answers;
        this.quiz = new Quiz(quizzes.getQuizId(),
                quizzes.getQuizName(),
                quizzes.getQuizDescription(),
                quizzes.getCategory(),
                quizzes.getTime());
    }
}
