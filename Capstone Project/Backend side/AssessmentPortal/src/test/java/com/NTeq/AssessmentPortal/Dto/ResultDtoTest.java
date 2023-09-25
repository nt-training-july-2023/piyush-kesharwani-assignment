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
}
