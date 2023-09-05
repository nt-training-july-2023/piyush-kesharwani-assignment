package com.NTeq.AssessmentPortal.Exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FieldsRequiredExceptionTest {

    @Test
    void testFieldsRequiredException() {
        String errorMessage = "Fields should not be empty";
        FieldsRequiredException exception = new 
                FieldsRequiredException(errorMessage);
        
        assertEquals(errorMessage,exception.getMessage());
        
    }

}
