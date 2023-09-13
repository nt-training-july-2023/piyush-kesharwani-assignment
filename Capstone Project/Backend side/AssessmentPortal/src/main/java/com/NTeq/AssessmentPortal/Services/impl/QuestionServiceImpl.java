package com.NTeq.AssessmentPortal.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NTeq.AssessmentPortal.Dto.CategoryDto;
import com.NTeq.AssessmentPortal.Dto.QuestionDto;
import com.NTeq.AssessmentPortal.Dto.QuizDto;
import com.NTeq.AssessmentPortal.Entity.Category;
import com.NTeq.AssessmentPortal.Entity.Question;
import com.NTeq.AssessmentPortal.Entity.Quiz;
import com.NTeq.AssessmentPortal.Repositories.QuestionRepository;
import com.NTeq.AssessmentPortal.Services.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    
    @Override
    public String addQuestion(QuestionDto questionDto) {
       Question question = new Question();
        Question resultedquestion = this.dtoToQuestion(questionDto,question);
        questionRepository.save(resultedquestion);
        return "Question added successfully";
    }

    @Override
    public QuestionDto getQuestionById(long questionId) {
        Question question = questionRepository.findById(questionId).orElse(null);
        if (question != null) {
            return questionToDto(question, new QuestionDto());
        }
        return null;
    }

    @Override
    public String updateQuestion(long questionId, QuestionDto questionDto) {
        Question existingQuestion = questionRepository.findById(questionId).orElse(null);
        if (existingQuestion != null) {
            Question updatedQuestion = this.dtoToQuestion(questionDto, existingQuestion);
            questionRepository.save(updatedQuestion);
            return "Question updated successfully";
        }
        return "Question not found";
    }

    @Override
    public void deleteQuestion(long questionId) {
        questionRepository.deleteById(questionId);
        
    }

    private Question dtoToQuestion(QuestionDto questionDto, Question question) {
        

        question.setQuestionId(questionDto.getQuestionId());
        question.setQuestionName(questionDto.getQuestionName());
        question.setOptionOne(questionDto.getOptionOne());
        question.setOptionTwo(questionDto.getOptionTwo());
        question.setOptionThree(questionDto.getOptionThree());
        question.setOptionFour(questionDto.getOptionFour());
        question.setAnswer(questionDto.getAnswer());
        Category category = new Category();
        category.setCategoryId(
                questionDto.getQuiz().getCategory().getCategoryId());
        category.setCategoryName(questionDto.getQuiz().getCategory().getCategoryName());
        category.setDescription(
                questionDto.getQuiz().getCategory().getDescription());
        Quiz quiz = new Quiz(questionDto.getQuiz().getQuizId(),
                questionDto.getQuiz().getQuizName(),
                questionDto.getQuiz().getQuizDescription(),
                questionDto.getQuiz().getTime());
        question.setQuiz(quiz);
        return question;
       
    }

    private QuestionDto questionToDto(Question question, QuestionDto questionDto) {
       
        questionDto.setQuestionId(question.getQuestionId());
        questionDto.setQuestionName(question.getQuestionName());
        questionDto.setOptionOne(question.getOptionOne());
        questionDto.setOptionTwo(question.getOptionTwo());
        questionDto.setOptionThree(question.getOptionThree());
        questionDto.setOptionFour(question.getOptionFour());
        questionDto.setAnswer(question.getAnswer());
        CategoryDto categoryDto = new CategoryDto(
                question.getQuiz().getCategory().getCategoryId(),
                question.getQuiz().getCategory().getCategoryName(),
                question.getQuiz().getCategory().getDescription());
        QuizDto quizDTO = new QuizDto(question.getQuiz().getQuizId(),
                question.getQuiz().getQuizName(),
                question.getQuiz().getQuizDescription(),
                categoryDto, question.getQuiz().getTime());
        questionDto.setQuiz(quizDTO);
        return questionDto;
       
    }
}

