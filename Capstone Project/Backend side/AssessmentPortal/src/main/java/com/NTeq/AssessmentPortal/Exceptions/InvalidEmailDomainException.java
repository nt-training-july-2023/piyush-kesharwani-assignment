package com.NTeq.AssessmentPortal.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception indicating an invalid email domain.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidEmailDomainException extends RuntimeException {

    /**
    * Serial version UID for serialization/deserialization compatibility.
    */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new InvalidEmailDomainException.
     * @param message The error message indicating the invalid email domain.
     */
    public InvalidEmailDomainException(final String message) {
        super(message);
    }
}
