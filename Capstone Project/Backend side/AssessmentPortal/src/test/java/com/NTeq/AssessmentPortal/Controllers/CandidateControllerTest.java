package com.NTeq.AssessmentPortal.Controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.NTeq.AssessmentPortal.Dto.CandidateDto;
import com.NTeq.AssessmentPortal.Dto.LoginRequestDto;
import com.NTeq.AssessmentPortal.Response.SuccessResponse;
import com.NTeq.AssessmentPortal.Services.impl.CandidateServiceImpl;
@ExtendWith(MockitoExtension.class)
class CandidateControllerTest {

    @InjectMocks
    private CandidateController candidateController;

    @Mock
    private CandidateServiceImpl candidateService;

    @Test
    public void testSaveUser() {
        CandidateDto candidateDto = new CandidateDto();

        SuccessResponse response = new SuccessResponse(HttpStatus.CREATED.value(),
                "Candidate Register successfully.");
        when(candidateService.addCandidate(candidateDto)).thenReturn(response);
        
        ResponseEntity<SuccessResponse> expectedResponse = new ResponseEntity<SuccessResponse>(
                response,HttpStatus.CREATED);

        ResponseEntity<SuccessResponse> result = candidateController.saveUser(candidateDto);

        assertEquals(expectedResponse, result);
    }
    
    @Test
    public void testLoginCandidate() {
        LoginRequestDto loginRequestDto = new LoginRequestDto();

        Map<String, String> expectedloginResponse = new HashMap<>();
        expectedloginResponse.put("status", "Success");
        expectedloginResponse.put("message", "Login successfully");

        when(candidateService.loginCandidate(loginRequestDto)).thenReturn(expectedloginResponse);

        Map<String, String> response = candidateController.loginCandidate(loginRequestDto);

        assertEquals(expectedloginResponse , response);
    }
    
    @Test
    public void testAllCandidate() {
        List<CandidateDto> candidateDtoList = new ArrayList<>();
        when(candidateService.getAllCandidate()).thenReturn(candidateDtoList);

        List<CandidateDto> response = candidateController.allCandidate();

        assertEquals(candidateDtoList, response);
    }
}
