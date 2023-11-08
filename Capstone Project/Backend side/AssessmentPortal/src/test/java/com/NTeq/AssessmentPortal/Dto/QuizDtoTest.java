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
    
    @Test
    void testEqualsAndHashcode() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(1);
        categoryDto.setCategoryName("SpringBoot");
        categoryDto.setDescription("SpringBoot mcqs");
        
        QuizDto quizDto1 = new QuizDto();
        quizDto1.setQuizId(121);
        quizDto1.setQuizName("Science");
        quizDto1.setQuizDescription("mcqs");
        quizDto1.setCategory(categoryDto);
        quizDto1.setTime(10);
        
        QuizDto quizDto2 = new QuizDto();
        quizDto2.setQuizId(121);
        quizDto2.setQuizName("Science");
        quizDto2.setQuizDescription("mcqs");
        quizDto2.setCategory(categoryDto);
        quizDto2.setTime(10);
        
        assertTrue(quizDto1.equals(quizDto2));
        assertFalse(quizDto1.equals(null));
        assertFalse(quizDto1.equals(""));
        
        assertTrue(quizDto1.equals(quizDto1));
        assertEquals(quizDto1.hashCode(), quizDto2.hashCode());
        
        quizDto2.setQuizId(1);
        assertNotEquals(quizDto1.hashCode(), quizDto2.hashCode());
        assertFalse(quizDto1.equals(quizDto2));
        
        quizDto2.setQuizId(121);
        quizDto2.setQuizName("maths");
        assertNotEquals(quizDto1.hashCode(), quizDto2.hashCode());
        assertFalse(quizDto1.equals(quizDto2));
        
        quizDto2.setQuizName("Science");
        quizDto2.setQuizDescription("desc");
        assertNotEquals(quizDto1.hashCode(), quizDto2.hashCode());
        assertFalse(quizDto1.equals(quizDto2));
        
        quizDto2.setQuizDescription("mcqs");
        quizDto2.setCategory(new CategoryDto());
        assertNotEquals(quizDto1.hashCode(), quizDto2.hashCode());
        assertFalse(quizDto1.equals(quizDto2));
        
        quizDto2.setCategory(categoryDto);
        quizDto2.setTime(19);
        assertNotEquals(quizDto1.hashCode(), quizDto2.hashCode());
        assertFalse(quizDto1.equals(quizDto2));
    }

}
