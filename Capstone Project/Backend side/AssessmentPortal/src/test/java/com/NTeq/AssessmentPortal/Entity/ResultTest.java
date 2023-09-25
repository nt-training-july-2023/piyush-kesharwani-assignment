package com.NTeq.AssessmentPortal.Entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultTest {

    Result result;
    @BeforeEach
    void init() {
        result = new Result();
    }
    
    @Test
    void testGettersAndSetters() {
        result.setResultId(10);
        result.setTotalMarks(100);
        result.setObtainedMarks(90);
        result.setUserEmail("Aakash@nucleusTeq.com");
        result.setUserName("Aakash Singh");
        result.setDateTime("12/07/23 05:34:45");
        result.setQuizName("SpringBoot");
        result.setCategoryName("Java");
        result.setAttemptedQuestion(95);
        result.setTotalQuestion(100);
        
        assertEquals(10,result.getResultId());
        assertEquals(100,result.getTotalMarks());
        assertEquals(90,result.getObtainedMarks());
        assertEquals("Aakash@nucleusTeq.com",result.getUserEmail());
        assertEquals("Aakash Singh",result.getUserName());
        assertEquals("12/07/23 05:34:45",result.getDateTime());
        assertEquals("SpringBoot",result.getQuizName());
        assertEquals("Java",result.getCategoryName());
        assertEquals(95,result.getAttemptedQuestion());
        assertEquals(100,result.getTotalQuestion());
    }

    @Test
    void testNoArgsConstructor() {
        assertEquals(0,result.getResultId());
        assertEquals(0,result.getTotalMarks());
        assertEquals(0,result.getObtainedMarks());
        assertEquals(null,result.getUserEmail());
        assertEquals(null,result.getUserName());
        assertEquals(null,result.getDateTime());
        assertEquals(null,result.getQuizName());
        assertEquals(null,result.getCategoryName());
        assertEquals(0,result.getAttemptedQuestion());
        assertEquals(0,result.getTotalQuestion());
    }
    
    @Test
    void testAllArgsConstructor() {
        Result result = new Result(10,100,90 ,"Aakash@nucleusTeq.com","Aakash Singh"
                ,"12/07/23 05:34:45","SpringBoot","Java",95,100);
        assertEquals(10,result.getResultId());
        assertEquals(100,result.getTotalMarks());
        assertEquals(90,result.getObtainedMarks());
        assertEquals("Aakash@nucleusTeq.com",result.getUserEmail());
        assertEquals("Aakash Singh",result.getUserName());
        assertEquals("12/07/23 05:34:45",result.getDateTime());
        assertEquals("SpringBoot",result.getQuizName());
        assertEquals("Java",result.getCategoryName());
        assertEquals(95,result.getAttemptedQuestion());
        assertEquals(100,result.getTotalQuestion());
    }
}
