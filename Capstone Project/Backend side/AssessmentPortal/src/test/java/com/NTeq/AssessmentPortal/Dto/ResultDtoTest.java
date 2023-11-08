package com.NTeq.AssessmentPortal.Dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ResultDtoTest {

    ResultDto resultDto;

    @BeforeEach
    void init() {
        resultDto = new ResultDto();
    }

    @Test
    void testGettersAndSetters() {
        resultDto.setResultId(10);
        resultDto.setTotalMarks(100);
        resultDto.setObtainedMarks(90);
        resultDto.setUserEmail("Aakash@nucleusTeq.com");
        resultDto.setUserName("Aakash Singh");
        resultDto.setDateTime("12/07/23 05:34:45");
        resultDto.setQuizName("SpringBoot");
        resultDto.setCategoryName("Java");
        resultDto.setAttemptedQuestion(95);
        resultDto.setTotalQuestion(100);

        assertEquals(10, resultDto.getResultId());
        assertEquals(100, resultDto.getTotalMarks());
        assertEquals(90, resultDto.getObtainedMarks());
        assertEquals("Aakash@nucleusTeq.com", resultDto.getUserEmail());
        assertEquals("Aakash Singh", resultDto.getUserName());
        assertEquals("12/07/23 05:34:45", resultDto.getDateTime());
        assertEquals("SpringBoot", resultDto.getQuizName());
        assertEquals("Java", resultDto.getCategoryName());
        assertEquals(95, resultDto.getAttemptedQuestion());
        assertEquals(100, resultDto.getTotalQuestion());
    }

    @Test
    void testNoArgsConstructor() {
        assertEquals(0,resultDto.getResultId());
        assertEquals(0,resultDto.getTotalMarks());
        assertEquals(0,resultDto.getObtainedMarks());
        assertEquals(null,resultDto.getUserEmail());
        assertEquals(null,resultDto.getUserName());
        assertEquals(null,resultDto.getDateTime());
        assertEquals(null,resultDto.getQuizName());
        assertEquals(null,resultDto.getCategoryName());
        assertEquals(0,resultDto.getAttemptedQuestion());
        assertEquals(0,resultDto.getTotalQuestion());
    }
    
    @Test
    void testAllArgsConstructor() {
        ResultDto resultDto = new ResultDto(10,100,90 ,"Aakash@nucleusTeq.com","Aakash Singh"
                ,"12/07/23 05:34:45","SpringBoot","Java",95,100);
        assertEquals(10,resultDto.getResultId());
        assertEquals(100,resultDto.getTotalMarks());
        assertEquals(90,resultDto.getObtainedMarks());
        assertEquals("Aakash@nucleusTeq.com",resultDto.getUserEmail());
        assertEquals("Aakash Singh",resultDto.getUserName());
        assertEquals("12/07/23 05:34:45",resultDto.getDateTime());
        assertEquals("SpringBoot",resultDto.getQuizName());
        assertEquals("Java",resultDto.getCategoryName());
        assertEquals(95,resultDto.getAttemptedQuestion());
        assertEquals(100,resultDto.getTotalQuestion());
    }
    
    @Test
    void testEqualAndHashcode() {
        ResultDto resultDto1 = new ResultDto();
        resultDto1.setResultId(22);
        resultDto1.setTotalMarks(100);
        resultDto1.setObtainedMarks(90);
        resultDto1.setUserEmail("Aakash@nucleusTeq.com");
        resultDto1.setUserName("Aakash Singh");
        resultDto1.setDateTime("12/07/23 05:34:45");
        resultDto1.setQuizName("SpringBoot");
        resultDto1.setCategoryName("Java");
        resultDto1.setAttemptedQuestion(95);
        resultDto1.setTotalQuestion(100);
        
        ResultDto resultDto2 = new ResultDto();
        resultDto2.setResultId(22);
        resultDto2.setTotalMarks(100);
        resultDto2.setObtainedMarks(90);
        resultDto2.setUserEmail("Aakash@nucleusTeq.com");
        resultDto2.setUserName("Aakash Singh");
        resultDto2.setDateTime("12/07/23 05:34:45");
        resultDto2.setQuizName("SpringBoot");
        resultDto2.setCategoryName("Java");
        resultDto2.setAttemptedQuestion(95);
        resultDto2.setTotalQuestion(100);
        
        assertTrue(resultDto1.equals(resultDto2));
        assertFalse(resultDto1.equals(null));
        assertFalse(resultDto1.equals(""));
        
        assertTrue(resultDto1.equals(resultDto1));
        assertEquals(resultDto1.hashCode(), resultDto2.hashCode());
        
        resultDto2.setResultId(12);
        assertNotEquals(resultDto1.hashCode(), resultDto2.hashCode());
        assertFalse(resultDto1.equals(resultDto2));
        
        resultDto2.setResultId(22);
        resultDto2.setTotalMarks(50);
        assertNotEquals(resultDto1.hashCode(), resultDto2.hashCode());
        assertFalse(resultDto1.equals(resultDto2));
        
        resultDto2.setTotalMarks(100);
        resultDto2.setObtainedMarks(50);
        assertNotEquals(resultDto1.hashCode(), resultDto2.hashCode());
        assertFalse(resultDto1.equals(resultDto2));
        
        resultDto2.setObtainedMarks(90);
        resultDto2.setUserEmail("Aakash@gmail.com");
        assertNotEquals(resultDto1.hashCode(), resultDto2.hashCode());
        assertFalse(resultDto1.equals(resultDto2));
        
        resultDto2.setUserEmail("Aakash@nucleusTeq.com");
        resultDto2.setUserName("Raj");
        assertNotEquals(resultDto1.hashCode(), resultDto2.hashCode());
        assertFalse(resultDto1.equals(resultDto2));
        
        resultDto2.setUserName("Aakash Singh");
        resultDto2.setDateTime("12/10/23 06:34:45");
        assertNotEquals(resultDto1.hashCode(), resultDto2.hashCode());
        assertFalse(resultDto1.equals(resultDto2));
        
        resultDto2.setDateTime("12/07/23 05:34:45");
        resultDto2.setQuizName("React");
        assertNotEquals(resultDto1.hashCode(), resultDto2.hashCode());
        assertFalse(resultDto1.equals(resultDto2));
        
        resultDto2.setQuizName("SpringBoot");
        resultDto2.setCategoryName("Python");
        assertNotEquals(resultDto1.hashCode(), resultDto2.hashCode());
        assertFalse(resultDto1.equals(resultDto2));
        
        resultDto2.setCategoryName("Java");
        resultDto2.setAttemptedQuestion(20);
        assertNotEquals(resultDto1.hashCode(), resultDto2.hashCode());
        assertFalse(resultDto1.equals(resultDto2));
        
        resultDto2.setAttemptedQuestion(95);
        resultDto2.setTotalQuestion(50);
        assertNotEquals(resultDto1.hashCode(), resultDto2.hashCode());
        assertFalse(resultDto1.equals(resultDto2));
    }
}
