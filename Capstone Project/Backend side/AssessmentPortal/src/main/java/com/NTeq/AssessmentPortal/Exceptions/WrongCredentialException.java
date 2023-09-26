package com.NTeq.AssessmentPortal.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception indicating wrong credentials provided.
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class WrongCredentialException extends RuntimeException {

    /**
     * Serial version UID for serialization/deserialization compatibility.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructs a new WrongCredentialException.
     * @param message The error message indicating incorrect credentials.
     */
    public WrongCredentialException(final String message) {
        super(message);
    }
}
