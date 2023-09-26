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

import com.NTeq.AssessmentPortal.Dto.CandidateDto;
import com.NTeq.AssessmentPortal.Dto.LoginRequestDto;
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
        // Set up candidateDto with appropriate data

        when(candidateService.addCandidate(candidateDto)).thenReturn("Login successfully");

        String response = candidateController.saveUser(candidateDto);

        assertEquals("Login successfully", response);
    }
    
    @Test
    public void testLoginCandidate() {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        // Set up candidateDto with appropriate data

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
        // Set up candidateDtoList with some data

        when(candidateService.getAllCandidate()).thenReturn(candidateDtoList);

        List<CandidateDto> response = candidateController.allCandidate();

        assertEquals(candidateDtoList, response);
    }
}
