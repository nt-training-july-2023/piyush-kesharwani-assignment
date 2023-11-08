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
    
    @Test
    void testEqualsAndHashcode() {
        
        CandidateDto candidateDto1 = new CandidateDto();
        candidateDto1.setId(12);
        candidateDto1.setFirstName("Raj");
        candidateDto1.setLastName("Sharma");
        candidateDto1.setEmail("raj@nucleusTeq.com");
        candidateDto1.setPassword("raj890@");
        candidateDto1.setPhoneNumber("8765432190");
        candidateDto1.setUserRole("user");
        
        CandidateDto candidateDto2 = new CandidateDto();
        candidateDto2.setId(12);
        candidateDto2.setFirstName("Raj");
        candidateDto2.setLastName("Sharma");
        candidateDto2.setEmail("raj@nucleusTeq.com");
        candidateDto2.setPassword("raj890@");
        candidateDto2.setPhoneNumber("8765432190");
        candidateDto2.setUserRole("user");
        
        assertTrue(candidateDto1.equals(candidateDto2));
        assertFalse(candidateDto1.equals(null));
        assertFalse(candidateDto1.equals(""));
        
        assertTrue(candidateDto1.equals(candidateDto1));
        assertEquals(candidateDto1.hashCode(), candidateDto2.hashCode());
        
        candidateDto2.setId(12);
        candidateDto2.setFirstName("Rio");
        assertNotEquals(candidateDto1.hashCode(), candidateDto2.hashCode());
        assertFalse(candidateDto1.equals(candidateDto2));
        
        candidateDto2.setFirstName("Raj");
        candidateDto2.setLastName("Kumar");
        assertNotEquals(candidateDto1.hashCode(), candidateDto2.hashCode());
        assertFalse(candidateDto1.equals(candidateDto2));
        
        candidateDto2.setLastName("Sharma");
        candidateDto2.setEmail("rj@nucleusTeq.com");
        assertNotEquals(candidateDto1.hashCode(), candidateDto2.hashCode());
        assertFalse(candidateDto1.equals(candidateDto2));
        
        candidateDto2.setEmail("raj@nucleusTeq.com");
        candidateDto2.setPassword("rj123@");
        assertNotEquals(candidateDto1.hashCode(), candidateDto2.hashCode());
        assertFalse(candidateDto1.equals(candidateDto2));
        
        candidateDto2.setPassword("raj890@");
        candidateDto2.setPhoneNumber("99928633");
        assertNotEquals(candidateDto1.hashCode(), candidateDto2.hashCode());
        assertFalse(candidateDto1.equals(candidateDto2));;
    }
    
}
