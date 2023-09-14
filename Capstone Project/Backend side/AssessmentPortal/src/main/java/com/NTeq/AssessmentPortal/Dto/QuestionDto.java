package com.NTeq.AssessmentPortal.Dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Data Transfer Object (DTO) class representing a Question's information.
 */
@Getter
@Setter
@NoArgsConstructor
public class QuestionDto {
    /**
     * The unique ID of the question.
     */
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
     * The associated QuizDto to which this question belongs.
     */
    private QuizDto quiz;
    /**
     * Constructor to initialize a QuestionDto with its attributes.
     * @param questionId     The unique identifier for this question.
     * @param questionName   The name or text of the question.
     * @param optionOne      The first option for answering the question.
     * @param optionTwo      The second option for answering the question.
     * @param optionThree    The third option for answering the question.
     * @param optionFour     The fourth option for answering the question.
     * @param answer         The correct answer to the question.
     * @param qz             The associated QuizDto to which this question belongs.
     */
    public QuestionDto(long questionId, String questionName, String optionOne,
            String optionTwo, String optionThree, String optionFour,
            String answer, QuizDto qz) {
        super();
        this.questionId = questionId;
        this.questionName = questionName;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.answer = answer;
        this.quiz = new QuizDto(qz.getQuizId(),qz.getQuizName(),
                qz.getQuizDescription(),qz.getCategory(),qz.getTime());
    }
    /**
     * Get the associated QuizDto for this question.
     * @return The QuizDto to which this question belongs.
     */
    public final QuizDto getQuiz() {
        return new QuizDto(quiz.getQuizId(), quiz.getQuizName(),
                quiz.getQuizDescription(),
                quiz.getCategory(),quiz.getTime());
    }
    /**
     * Set the associated QuizDto for this question.
     * @param paramQuiz The QuizDto to associate with this question.
     * 
     */
    public final void setQuiz(final QuizDto paramQuiz) {
        this.quiz = new QuizDto(paramQuiz.getQuizId(), paramQuiz.getQuizName(),
                paramQuiz.getQuizDescription(),
                paramQuiz.getCategory(),paramQuiz.getTime());
    }
}
