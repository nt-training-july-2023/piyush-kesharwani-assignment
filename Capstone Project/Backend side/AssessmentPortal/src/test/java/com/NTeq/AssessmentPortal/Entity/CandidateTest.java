package com.NTeq.AssessmentPortal.Entity;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CandidateTest {
  
    Candidate candidate;
    @BeforeEach
    void init() {
       candidate= new Candidate();
    }
    
    @Test
    void testAllSettersGetters() {
     assertEquals(0,candidate.getId());
     assertEquals(null,candidate.getFirstName());
     assertEquals(null,candidate.getLastName());
     assertEquals(null,candidate.getEmail());
     assertEquals(null,candidate.getPassword());
     assertEquals(null,candidate.getPhoneNumber());
     assertEquals(null,candidate.getUserRole());
     
     
     candidate.setId(12);
     candidate.setFirstName("Raj");
     candidate.setLastName("Sharma");
     candidate.setEmail("raj@nucleusTeq.com");
     candidate.setPassword("raj890@");
     candidate.setPhoneNumber("8765432190");
     candidate.setUserRole("user");
     
     assertEquals(12,candidate.getId());
     assertEquals("Raj",candidate.getFirstName());
     assertEquals("Sharma",candidate.getLastName());
     assertEquals("raj@nucleusTeq.com",candidate.getEmail());
     assertEquals("raj890@",candidate.getPassword());
     assertEquals("8765432190",candidate.getPhoneNumber());
     assertEquals("user",candidate.getUserRole());
    }

    @Test
    void testDefaultConstructor() {
        Candidate candidate = new Candidate();
        assertEquals(0,candidate.getId());
        assertEquals(null,candidate.getFirstName());
        assertEquals(null,candidate.getLastName());
        assertEquals(null,candidate.getEmail());
        assertEquals(null,candidate.getPassword());
        assertEquals(null,candidate.getPhoneNumber());
        assertEquals(null,candidate.getUserRole());
    }
    
    @Test
    void testParameterizedConstructor() {
        Candidate candidate = new Candidate(13,"Raj","Sharma","raj@nucleusTeq.com"
                ,"raj890@","user","8765432190");
        assertEquals(13,candidate.getId());
        assertEquals("Raj",candidate.getFirstName());
        assertEquals("Sharma",candidate.getLastName());
        assertEquals("raj@nucleusTeq.com",candidate.getEmail());
        assertEquals("raj890@",candidate.getPassword());
        assertEquals("8765432190",candidate.getPhoneNumber());
        assertEquals("user",candidate.getUserRole());
        
    }

}
