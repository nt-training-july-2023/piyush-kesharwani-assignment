package com.NTeq.AssessmentPortal.Dto;

import com.NTeq.AssessmentPortal.Entity.Options;

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
     * The options of the question.
     */
    private Options options;
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
     * @param questionsId     The unique identifier for this question.
     * @param questionsName   The name or text of the question.
     * @param paramOptions      The options for answering the question.
     * @param answers         The correct answer to the question.
     * @param qz        The associated QuizDto to which this question belongs.
     */
    public QuestionDto(final long questionsId, final String questionsName,
            final Options paramOptions,
            final String answers, final QuizDto qz) {
        super();
        this.questionId = questionsId;
        this.questionName = questionsName;
        this.options = new Options(paramOptions.getOptionOne(),
                paramOptions.getOptionTwo(), paramOptions.getOptionThree(),
                paramOptions.getOptionFour());
        this.answer = answers;
        this.quiz = new QuizDto(qz.getQuizId(), qz.getQuizName(),
                qz.getQuizDescription(), qz.getCategory(), qz.getTime());
    }
    /**
     * Getter for getting the options.
     * @return Options object.
     */
    public final Options getOptions() {
        return new Options(options.getOptionOne(), options.getOptionTwo(),
                options.getOptionThree(), options.getOptionFour());
    }
    /**
     * Setter for setting the options.
     * @param paramOptions The options of Question.
     */
    public final void setOptions(final Options paramOptions) {
        this.options = new Options(paramOptions.getOptionOne(),
                paramOptions.getOptionTwo(), paramOptions.getOptionThree(),
                paramOptions.getOptionFour());
    }
    /**
     * Get the associated QuizDto for this question.
     * @return The QuizDto to which this question belongs.
     */
    public final QuizDto getQuiz() {
        return new QuizDto(quiz.getQuizId(), quiz.getQuizName(),
                quiz.getQuizDescription(),
                quiz.getCategory(), quiz.getTime());
    }
    /**
     * Set the associated QuizDto for this question.
     * @param paramQuiz The QuizDto to associate with this question.
     */
    public final void setQuiz(final QuizDto paramQuiz) {
        this.quiz = new QuizDto(paramQuiz.getQuizId(), paramQuiz.getQuizName(),
                paramQuiz.getQuizDescription(),
                paramQuiz.getCategory(), paramQuiz.getTime());
    }
}
