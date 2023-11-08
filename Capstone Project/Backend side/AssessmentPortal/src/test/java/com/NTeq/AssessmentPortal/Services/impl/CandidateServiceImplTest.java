package com.NTeq.AssessmentPortal.Services.impl;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.NTeq.AssessmentPortal.Dto.CandidateDto;
import com.NTeq.AssessmentPortal.Dto.LoginRequestDto;
import com.NTeq.AssessmentPortal.Entity.Candidate;
import com.NTeq.AssessmentPortal.Exceptions.DuplicateEmail;
import com.NTeq.AssessmentPortal.Exceptions.FieldsRequiredException;
import com.NTeq.AssessmentPortal.Exceptions.InvalidEmailDomainException;
import com.NTeq.AssessmentPortal.Exceptions.WrongCredentialException;
import com.NTeq.AssessmentPortal.Repositories.CandidateRepository;
import com.NTeq.AssessmentPortal.Response.Message;
import com.NTeq.AssessmentPortal.Response.SuccessResponse;

@ExtendWith(MockitoExtension.class)
class CandidateServiceImplTest {

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CandidateServiceImpl candidateService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testGetAllCandidate_WithCandidates_ShouldReturnListOfCandidates() {
        List<Candidate> candidates = new ArrayList<>();
        Candidate candidate1 = new Candidate(1,"Piyush","Kesharwani","piyush@nucleusTeq.com",
                "12345","9098765342","admin");
        Candidate candidate2 = new Candidate(2,"Vishal","Rao","vishal@nucleusTeq.com",
                "123456","9098765442","user");
        candidates.add(candidate1);
        candidates.add(candidate2);
        
        List<CandidateDto> candidateDto = new ArrayList<>();
       CandidateDto candidateDto1 = new CandidateDto(1,"Piyush","Kesharwani","piyush@nucleusTeq.com",
                "12345","9098765342","admin");
       CandidateDto candidateDto2 = new CandidateDto(2,"Vishal","Rao","vishal@nucleusTeq.com",
               "123456","9098765442","user");
        candidateDto.add(candidateDto1);
        candidateDto.add(candidateDto2);
        
        when(candidateRepository.findAll()).thenReturn(candidates);
        when(modelMapper.map(candidate1, CandidateDto.class)).thenReturn(candidateDto1);
        when(modelMapper.map(candidate2, CandidateDto.class)).thenReturn(candidateDto2);
        List<CandidateDto> result = candidateService.getAllCandidate();
        assertEquals(candidateDto, result);
    }

    @Test
    public void testGetAllCandidate_NoCandidates_ShouldReturnEmptyList() {
        List<Candidate> candidates = new ArrayList<>();
        when(candidateRepository.findAll()).thenReturn(candidates);
        List<CandidateDto> result = candidateService.getAllCandidate();

        assertTrue(result.isEmpty());
}
    
    @Test
    public void testAddCandidate_Success() throws DuplicateEmail, InvalidEmailDomainException ,FieldsRequiredException{
        CandidateDto candidateDto = new CandidateDto();
        candidateDto.setId(5);
        candidateDto.setFirstName("Sky");
        candidateDto.setLastName("singh");
        candidateDto.setEmail("Sky@nucleusTeq.com");
        candidateDto.setPassword("password");
        candidateDto.setUserRole("user");
        candidateDto.setPhoneNumber("1234567890");

        Candidate candidate = new Candidate();
        candidate.setId(candidateDto.getId());
        candidate.setFirstName(candidateDto.getFirstName());
        candidate.setLastName(candidateDto.getLastName());
        candidate.setEmail(candidateDto.getEmail());
        candidate.setPassword(candidateDto.getPassword());
        candidate.setUserRole(candidateDto.getUserRole());
        candidate.setPhoneNumber(candidateDto.getPhoneNumber());
        
        SuccessResponse expectedResponse = new SuccessResponse(HttpStatus.CREATED.value(),
                Message.REGISTERED_SUCCESSFULLY);

        when(candidateRepository.findByEmail(candidateDto.getEmail())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(candidateDto.getPassword())).thenReturn("encodedPassword");
        when(modelMapper.map(candidateDto, Candidate.class)).thenReturn(candidate);

        SuccessResponse result = candidateService.addCandidate(candidateDto);
        assertNotNull(result);
        assertEquals(expectedResponse , result);
    }

    @Test
    public void testAddUser_DuplicateEmail() {
        CandidateDto candidateDto = new CandidateDto();
        candidateDto.setId(5);
        candidateDto.setFirstName("Sky");
        candidateDto.setLastName("singh");
        candidateDto.setEmail("Sky@nucleusTeq.com");
        candidateDto.setPassword("password");
        candidateDto.setUserRole("user");
        candidateDto.setPhoneNumber("1234567890");
        
        Candidate candidate = new Candidate();
        candidate.setId(candidateDto.getId());
        candidate.setFirstName(candidateDto.getFirstName());
        candidate.setLastName(candidateDto.getLastName());
        candidate.setEmail(candidateDto.getEmail());
        candidate.setPassword(candidateDto.getPassword());
        candidate.setUserRole(candidateDto.getUserRole());
        candidate.setPhoneNumber(candidateDto.getPhoneNumber());
        
        when(candidateRepository.findByEmail(candidate.getEmail())).thenReturn(Optional.of(candidate));
        when(modelMapper.map(candidateDto, Candidate.class)).thenReturn(candidate);
        assertThrows(DuplicateEmail.class, () -> 
        candidateService.addCandidate(candidateDto));
    }

    @Test
    public void testLoginCandidate_Success() {
        LoginRequestDto candidateDto = new LoginRequestDto();
        candidateDto.setEmail("test@nucleusteq.com");
        candidateDto.setPassword("12345");
          
        Candidate candidate = new Candidate();
        candidate.setEmail(candidateDto.getEmail());
        candidate.setPassword(candidateDto.getPassword());
        when(candidateRepository.getByEmail(candidateDto.getEmail())).thenReturn(candidate);
        when(candidateRepository.findByEmailAndPassword(candidateDto.getEmail(), candidateDto.getPassword())).thenReturn(Optional.of(candidate));
        when(passwordEncoder.matches(any(), any())).thenReturn(true);
        Map<String, String> response = candidateService.loginCandidate(candidateDto);
        
        assertNotNull(response);
        assertEquals("Login Successfully", response.get("message"));
        assertEquals("true", response.get("status"));
        
    }
    
    @Test
    public void testLoginUser_WrongPassword() {
        LoginRequestDto candidateDto = new LoginRequestDto();
        candidateDto.setEmail("test@nucleusteq.com");
        candidateDto.setPassword("12345");
          
        Candidate candidate = new Candidate();
        candidate.setEmail(candidateDto.getEmail());
        candidate.setPassword(candidateDto.getPassword());
        when(candidateRepository.getByEmail(candidateDto.getEmail())).thenReturn(candidate);
        when(passwordEncoder.matches(any(), any())).thenReturn(false);
        assertThrows(WrongCredentialException.class, () ->
        candidateService.loginCandidate(candidateDto));
    }
}
