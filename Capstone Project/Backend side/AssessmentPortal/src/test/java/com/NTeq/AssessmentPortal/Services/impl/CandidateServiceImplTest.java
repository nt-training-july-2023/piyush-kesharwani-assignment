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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.NTeq.AssessmentPortal.Dto.CandidateDto;
import com.NTeq.AssessmentPortal.Dto.LoginRequestDto;
import com.NTeq.AssessmentPortal.Entity.Candidate;
import com.NTeq.AssessmentPortal.Exceptions.DuplicateEmail;
import com.NTeq.AssessmentPortal.Exceptions.FieldsRequiredException;
import com.NTeq.AssessmentPortal.Exceptions.InvalidEmailDomainException;
import com.NTeq.AssessmentPortal.Exceptions.WrongCredentialException;
import com.NTeq.AssessmentPortal.Repositories.CandidateRepository;

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
        // Arrange
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate());
        candidates.add(new Candidate());
        when(candidateRepository.findAll()).thenReturn(candidates);
        // Act
        List<CandidateDto> result = candidateService.getAllCandidate();
        // Assert
        assertEquals(2, result.size());
    }

    @Test
    public void testGetAllCandidate_NoCandidates_ShouldReturnEmptyList() {
        // Arrange
        List<Candidate> candidates = new ArrayList<>();
        when(candidateRepository.findAll()).thenReturn(candidates);
        // Act
        List<CandidateDto> result = candidateService.getAllCandidate();
        // Assert
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
        
        

        // Mock behavior for UserRepository
        when(candidateRepository.findByEmail(candidateDto.getEmail())).thenReturn(Optional.empty());
        // Mock behavior for PasswordEncoder
        when(passwordEncoder.encode(candidateDto.getPassword())).thenReturn("encodedPassword");
        when(modelMapper.map(candidateDto, Candidate.class)).thenReturn(candidate);

        String result = candidateService.addCandidate(candidateDto);
        assertNotNull(result);
        assertEquals("Sky@nucleusTeq.com registered successfully" , result);
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
        
        // Mock behavior for UserRepository
        when(candidateRepository.findByEmail(candidate.getEmail())).thenReturn(Optional.of(candidate));
        when(modelMapper.map(candidateDto, Candidate.class)).thenReturn(candidate);
        assertThrows(DuplicateEmail.class, () -> 
        candidateService.addCandidate(candidateDto));
    }
    
//    @Test
//    public void testAddUser_InvalidEmailDomain() {
//        CandidateDto candidateDto = new CandidateDto();
//        candidateDto.setId(5);
//        candidateDto.setFirstName("Sky");
//        candidateDto.setLastName("singh");
//        candidateDto.setEmail("Sky@gmail.com");
//        candidateDto.setPassword("password");
//        candidateDto.setUserRole("user");
//        candidateDto.setPhoneNumber("1234567890");
//        
//        Candidate candidate = new Candidate();
//        candidate.setId(candidateDto.getId());
//        candidate.setFirstName(candidateDto.getFirstName());
//        candidate.setLastName(candidateDto.getLastName());
//        candidate.setEmail(candidateDto.getEmail());
//        candidate.setPassword(candidateDto.getPassword());
//        candidate.setUserRole(candidateDto.getUserRole());
//        candidate.setPhoneNumber(candidateDto.getPhoneNumber());
//        
//        // Mock behavior for UserRepository
//        when(modelMapper.map(candidateDto, Candidate.class)).thenReturn(candidate);
//        assertThrows(InvalidEmailDomainException.class, () -> 
//        candidateService.addCandidate(candidateDto));
//    }
    
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
//        when(candidateRepository.findByEmailAndPassword(candidateDto.getEmail(), candidateDto.getPassword()))
//        .thenReturn(Optional.of(candidate));
        when(passwordEncoder.matches(any(), any())).thenReturn(false);
        assertThrows(WrongCredentialException.class, () ->
        candidateService.loginCandidate(candidateDto));
    }
}
