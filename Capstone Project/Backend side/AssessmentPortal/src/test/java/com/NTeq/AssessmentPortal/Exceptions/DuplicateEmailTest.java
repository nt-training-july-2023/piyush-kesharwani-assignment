package com.NTeq.AssessmentPortal.Exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DuplicateEmailTest {

    @Test
    void testDuplicateEmailTest() {
        String message = "Email already exists";
        DuplicateEmail exception = new DuplicateEmail(message);

        assertEquals(message, exception.getMessage());
    }

}
