package com.NTeq.AssessmentPortal.Dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CandidateDtoTest {
    
    CandidateDto candidateDto;
    @BeforeEach
    void init() {
        candidateDto = new CandidateDto();
    }
    
    @Test
    void testAllGetterAndSetter() {
        assertEquals(0,candidateDto.getId());
        assertEquals(null,candidateDto.getFirstName());
        assertEquals(null,candidateDto.getLastName());
        assertEquals(null,candidateDto.getEmail());
        assertEquals(null,candidateDto.getPassword());
        assertEquals(null,candidateDto.getPhoneNumber());
        assertEquals(null,candidateDto.getUserRole());
        
        candidateDto.setId(12);
        candidateDto.setFirstName("Raj");
        candidateDto.setLastName("Sharma");
        candidateDto.setEmail("raj@nucleusTeq.com");
        candidateDto.setPassword("raj890@");
        candidateDto.setPhoneNumber("8765432190");
        candidateDto.setUserRole("user");
        assertEquals(12,candidateDto.getId());
        assertEquals("Raj",candidateDto.getFirstName());
        assertEquals("Sharma",candidateDto.getLastName());
        assertEquals("raj@nucleusTeq.com",candidateDto.getEmail());
        assertEquals("raj890@",candidateDto.getPassword());
        assertEquals("8765432190",candidateDto.getPhoneNumber());
        assertEquals("user",candidateDto.getUserRole());
    }
    
    @Test
    void testDefaultConstructor() {
        CandidateDto candidatedto = new CandidateDto();
        assertEquals(0,candidatedto.getId());
        assertEquals(null,candidatedto.getFirstName());
        assertEquals(null,candidatedto.getLastName());
        assertEquals(null,candidatedto.getEmail());
        assertEquals(null,candidatedto.getPassword());
        assertEquals(null,candidatedto.getPhoneNumber());
        assertEquals(null,candidatedto.getUserRole());
    }
    
    @Test
    void testParameterizedConstructor() {
        CandidateDto candidateDto = new CandidateDto(13,"Raj","Sharma","raj@nucleusTeq.com"
                ,"raj890@","user","8765432190");
        assertEquals(13,candidateDto.getId());
        assertEquals("Raj",candidateDto.getFirstName());
        assertEquals("Sharma",candidateDto.getLastName());
        assertEquals("raj@nucleusTeq.com",candidateDto.getEmail());
        assertEquals("raj890@",candidateDto.getPassword());
        assertEquals("8765432190",candidateDto.getPhoneNumber());
        assertEquals("user",candidateDto.getUserRole());
        
    }

}
