package com.NTeq.AssessmentPortal.Exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WrongCredentialExceptionTest {

    @Test
    void testWrongCredential() {
        String message = "Invalid Credentials";
        WrongCredentialException exception = new WrongCredentialException(message);
        
        assertEquals(message,exception.getMessage());
    }

}
