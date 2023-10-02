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

        ResponseEntity<SuccessResponse> result = candidateController.saveUser(candidateDto);

        assertEquals(HttpStatus.CREATED , result.getStatusCode());
        assertEquals(response, result.getBody());
    }
    
    @Test
    public void testLoginCandidate() {
        LoginRequestDto loginRequestDto = new LoginRequestDto();

        Map<String, String> loginResponse = new HashMap<>();
        loginResponse.put("status", "Success");
        loginResponse.put("message", "Login successfully");

        when(candidateService.loginCandidate(loginRequestDto)).thenReturn(loginResponse);

        Map<String, String> response = candidateController.loginCandidate(loginRequestDto);

        assertEquals("Success", response.get("status"));
        assertEquals("Login successfully", response.get("message"));
    }
    
    @Test
    public void testAllCandidate() {
        List<CandidateDto> candidateDtoList = new ArrayList<>();
        when(candidateService.getAllCandidate()).thenReturn(candidateDtoList);

        List<CandidateDto> response = candidateController.allCandidate();

        assertEquals(candidateDtoList, response);
    }
}
