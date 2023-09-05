package com.NTeq.AssessmentPortal.Services.impl;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
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
import com.NTeq.AssessmentPortal.Entity.Candidate;
import com.NTeq.AssessmentPortal.Exceptions.DuplicateEmail;
import com.NTeq.AssessmentPortal.Exceptions.FieldsRequiredException;
import com.NTeq.AssessmentPortal.Exceptions.InvalidEmailDomainException;
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
        candidateDto.setUserRole("user");
        candidateDto.setEmail("Sky@nucleusTeq.com");
        candidateDto.setPassword("password");
        candidateDto.setFirstName("Sky");
        candidateDto.setLastName("singh");
        candidateDto.setPhoneNumber("1234567890");

        // Mock behavior for UserRepository
        when(candidateRepository.findByEmail(candidateDto.getEmail())).thenReturn(Optional.empty());
        // Mock behavior for PasswordEncoder
        when(passwordEncoder.encode(candidateDto.getPassword())).thenReturn("encodedPassword");

//        String result = candidateService.addCandidate(candidateDto);
//        assertNull(result);
//        assertEquals("Sky@nucleusTeq.com registered successfully" , result);
    }

}
