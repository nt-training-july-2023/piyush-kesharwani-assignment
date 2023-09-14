package com.NTeq.AssessmentPortal.Dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class QuizDtoTest {

    QuizDto quizDto;
    @BeforeEach
    void init() {
        quizDto = new QuizDto();
    }
    
    @Test
    void testGettersAndSetters() {
        quizDto.setQuizId(10);
        quizDto.setQuizName("Maths");
        quizDto.setQuizDescription("Maths Mcqs");
        quizDto.setTime(45);
       
       assertEquals(10, quizDto.getQuizId());
       assertEquals("Maths", quizDto.getQuizName());
       assertEquals("Maths Mcqs", quizDto.getQuizDescription());
       assertEquals(45, quizDto.getTime());
    }
    
    
    @Test
    void testNoArgConstructor() {
        assertEquals(0, quizDto.getQuizId());
        assertEquals(null, quizDto.getQuizName());
        assertEquals(null, quizDto.getQuizDescription());
        assertEquals(0, quizDto.getTime());
    }
    
    @Test
    void testAllArgConstructor() {
        CategoryDto catDto = new CategoryDto(1,"Science","Description");
        QuizDto q = new QuizDto(12,"Science","Science Mcqs",catDto,60);
        assertEquals(12, q.getQuizId());
        assertEquals("Science", q.getQuizName());
        assertEquals("Science Mcqs", q.getQuizDescription());
        CategoryDto testcategory = q.getCategory();
        assertEquals(1,testcategory.getCategoryId());
        assertEquals("Science",testcategory.getCategoryName());
        assertEquals("Description",testcategory.getDescription());
        assertEquals(60, q.getTime());
    }

}
