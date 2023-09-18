package com.NTeq.AssessmentPortal.Dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.NTeq.AssessmentPortal.Entity.Options;

class QuestionDtoTest {

    QuestionDto questionDto;
    @BeforeEach
    void init() {
        questionDto = new QuestionDto();
    }
    
    @Test
    void testAllGetterSetter() {
        questionDto.setQuestionId(121);
        questionDto.setQuestionName("Which is not a programming language");
        Options op = new Options("Java","C++","MYSQL","Python");
        questionDto.setOptions(op);
        questionDto.setAnswer("MYSQL");
        
        CategoryDto cat = new CategoryDto(1,"Programming language","All programming mcqs");
        QuizDto qz = new QuizDto();
        qz.setQuizId(12);
        qz.setQuizName("Java");
        qz.setQuizDescription("Java mcqs");
        qz.setCategory(cat);
        qz.setTime(60);
        questionDto.setQuiz(qz);
        assertEquals(121,questionDto.getQuestionId());
        assertEquals("Which is not a programming language",questionDto.getQuestionName());
        assertEquals("Java",questionDto.getOptions().getOptionOne());
        assertEquals("C++",questionDto.getOptions().getOptionTwo());
        assertEquals("MYSQL",questionDto.getOptions().getOptionThree());
        assertEquals("Python",questionDto.getOptions().getOptionFour());
        assertEquals("MYSQL",questionDto.getAnswer());
        assertEquals(qz.getQuizId(),questionDto.getQuiz().getQuizId());
    }

    @Test
    void testAllArgConstructor() {
        CategoryDto cat = new CategoryDto(1,"Programming language","All programming mcqs");
        QuizDto qz = new QuizDto(12,"Java","Java mcqs",cat,60);
        Options optn = new Options("Java","C++","MYSQL","Python");
        QuestionDto questionDto = new QuestionDto(121,"Which is not a programming language",
                optn,"MYSQL",qz);
        assertEquals(121,questionDto.getQuestionId());
      }
}
