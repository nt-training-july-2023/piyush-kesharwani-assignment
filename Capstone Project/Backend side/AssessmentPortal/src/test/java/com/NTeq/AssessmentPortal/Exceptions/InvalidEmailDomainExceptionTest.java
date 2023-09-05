package com.NTeq.AssessmentPortal.Exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InvalidEmailDomainExceptionTest {

    @Test
    void testEmailDomain() {
        String message = "email should end with @nucleusTeq.com";
        InvalidEmailDomainException ex = new InvalidEmailDomainException(message);
        
        assertEquals(message,ex.getMessage());
    }

}
