package com.NTeq.AssessmentPortal.Exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResourceNotFoundTest {

    @Test
    void testResourceNotFound() {
       String message = "User doesn't exists";
       ResourceNotFound ex = new ResourceNotFound(message);
       
       assertEquals(message,ex.getMessage());
    }

}
