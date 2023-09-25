package com.NTeq.AssessmentPortal.Controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.NTeq.AssessmentPortal.Dto.ResultDto;
import com.NTeq.AssessmentPortal.Services.impl.ResultServiceImpl;

class ResultControllerTest {
    @InjectMocks
    private ResultController resultController;

    @Mock
    private ResultServiceImpl resultService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testSaveResult() {
        ResultDto resultDto = new ResultDto();
        resultDto.setResultId(1L);
        resultDto.setUserEmail("Aakash@nucleusTeq.com");

        when(resultService.addResult(resultDto)).thenReturn("Result saved successfully");

        String response = resultController.saveResult(resultDto);

        assertEquals("Result saved successfully", response);
    }

    @Test
    public void testGetAll() {
        List<ResultDto> resultList = new ArrayList<>();
        resultList.add(new ResultDto(10,100,90,"Aakash@nucleusTeq.com","Aakash Singh",
                "12/07/23 05:34:45","SpringBoot","Java",95,100));
        resultList.add(new ResultDto(10,100,85,"Aman@nucleusTeq.com","Aman Singh",
                "12/07/23 05:37:45","SpringBoot","Java",95,100));

        when(resultService.getAllResult()).thenReturn(resultList);

        ResponseEntity<List<ResultDto>> responseEntity = resultController.getAll();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(resultList, responseEntity.getBody());
    }

    @Test
    public void testFindByEmailId() {
        String email = "test@example.com";
        List<ResultDto> resultList = new ArrayList<>();
        resultList.add(new ResultDto(10,100,90,"Aakash@nucleusTeq.com","Aakash Singh",
                "12/07/23 05:34:45","SpringBoot","Java",95,100));
        resultList.add(new ResultDto(10,100,85,"Aman@nucleusTeq.com","Aman Singh",
                "12/07/23 05:37:45","SpringBoot","Java",95,100));

        when(resultService.getresultByEmail(email)).thenReturn(resultList);

        ResponseEntity<List<ResultDto>> responseEntity = resultController.findByEmailId(email);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(resultList, responseEntity.getBody());
    }
    
}
