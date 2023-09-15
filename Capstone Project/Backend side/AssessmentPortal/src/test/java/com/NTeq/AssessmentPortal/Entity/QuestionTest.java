package com.NTeq.AssessmentPortal.Entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuestionTest {

    Question question;
    @BeforeEach
    void init() {
        question = new Question();
    }
    
    @Test
    void GettersAndSetters() {
        question.setQuestionId(121);
        question.setQuestionName("Which is not a programming language");
        question.setOptionOne("Java");
        question.setOptionTwo("C++");
        question.setOptionThree("MYSQL");
        question.setOptionFour("Python");
        question.setAnswer("MYSQL");
        
        Category cat = new Category(1,"Programming language","All programming mcqs");
        Quiz qz = new Quiz();
        qz.setQuizId(12);
        qz.setQuizName("Java");
        qz.setQuizDescription("Java mcqs");
        qz.setCategory(cat);
        qz.setTime(60);
        question.setQuiz(qz);
        assertEquals(121,question.getQuestionId());
        assertEquals("Which is not a programming language",question.getQuestionName());
        assertEquals("Java",question.getOptionOne());
        assertEquals("C++",question.getOptionTwo());
        assertEquals("MYSQL",question.getOptionThree());
        assertEquals("Python",question.getOptionFour());
        assertEquals("MYSQL",question.getAnswer());
        assertEquals(qz.getQuizId(),question.getQuiz().getQuizId());
    }
  
    @Test
    void testNoArgConstructor() {
        assertEquals(0,question.getQuestionId());
        assertEquals(null,question.getQuestionName());
        assertEquals(null,question.getOptionOne());
        assertEquals(null,question.getOptionTwo());
        assertEquals(null,question.getOptionThree());
        assertEquals(null,question.getOptionFour());
        assertEquals(null,question.getAnswer());
      }
    
    @Test
    void testAllArgConstructor() {
        Category c = new Category(1,"Programming language","All programming mcqs");
        Quiz qz = new Quiz(12,"Java","Java mcqs",c,60);
        Question q = new Question(121,"Which is not a programming language","Java",
                "C++","MYSQL","Python","MYSQL",qz);
        assertEquals(121,q.getQuestionId());
        assertEquals("Which is not a programming language",q.getQuestionName());
        assertEquals("Java",q.getOptionOne());
        assertEquals("C++",q.getOptionTwo());
        assertEquals("MYSQL",q.getOptionThree());
        assertEquals("Python",q.getOptionFour());
        assertEquals("MYSQL",q.getAnswer());
        assertEquals(qz.getQuizId(),q.getQuiz().getQuizId());
    }
}
