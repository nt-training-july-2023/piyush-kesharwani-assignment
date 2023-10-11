package com.NTeq.AssessmentPortal.Response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SuccessResponseTest {
    
    @Test
    public void testAllArgsConstructor() {
        int statusCode = 200;
        String message = "OK";

        SuccessResponse response = new SuccessResponse(statusCode, message);

        assertEquals(200 , response.getStatusCode());
        assertEquals("OK" , response.getMessage());

        response.setStatusCode(201);
        response.setMessage("Created");

        assertEquals(201 , response.getStatusCode());
        assertEquals("Created" , response.getMessage());

    }

}
