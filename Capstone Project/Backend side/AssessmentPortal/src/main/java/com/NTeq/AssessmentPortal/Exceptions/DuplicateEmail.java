package com.NTeq.AssessmentPortal.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception indicating that a duplicate email address was encountered.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateEmail extends RuntimeException {

    /**
     * Serial version UID for serialization/deserialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new DuplicateEmail exception with specified error message.
     * @param message The error message indicating the reason for exception.
     */
    public DuplicateEmail(final String message) {
        super(message);
    }

}
