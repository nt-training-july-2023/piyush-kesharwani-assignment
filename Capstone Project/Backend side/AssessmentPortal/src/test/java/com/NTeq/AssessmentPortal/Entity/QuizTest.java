package com.NTeq.AssessmentPortal.Entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuizTest {

    Quiz quiz;
    @BeforeEach
    void init() {
        quiz = new Quiz();
    }
    
    @Test
    void testGettersAndSetters() {
       quiz.setQuizId(10);
       quiz.setQuizName("Maths");
       quiz.setQuizDescription("Maths Mcqs");
       quiz.setTime(45);
       
       assertEquals(10, quiz.getQuizId());
       assertEquals("Maths", quiz.getQuizName());
       assertEquals("Maths Mcqs", quiz.getQuizDescription());
       assertEquals(45, quiz.getTime());
    }
    
    @Test
    void testCategoryGettersSetters() {
        Category category = new Category();
        quiz.setCategory(category);
        assertEquals(category.getCategoryId(), quiz.getCategory().getCategoryId());
    }
    
    @Test
    void testNoArgConstructor() {
        assertEquals(0, quiz.getQuizId());
        assertEquals(null, quiz.getQuizName());
        assertEquals(null, quiz.getQuizDescription());
        assertEquals(0, quiz.getTime());
    }
    
    @Test
    void testAllArgConstructor() {
        Quiz q = new Quiz(12,"Science","Science Mcqs",60);
        assertEquals(12, q.getQuizId());
        assertEquals("Science", q.getQuizName());
        assertEquals("Science Mcqs", q.getQuizDescription());
        assertEquals(60, q.getTime());
    }

}
