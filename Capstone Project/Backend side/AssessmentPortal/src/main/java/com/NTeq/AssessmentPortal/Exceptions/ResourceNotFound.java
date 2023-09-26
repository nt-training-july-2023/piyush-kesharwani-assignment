package com.NTeq.AssessmentPortal.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception indicating an Resource not found.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {
    /**
    * Serial version UID for serialization/deserialization compatibility.
    */
    private static final long serialVersionUID = 1L;
    /**
     * Constructs a new ResourceNotFoundException.
     * @param message The error message indicating the resource not found.
     */
    public ResourceNotFound(final String message) {
        super(message);
    }
}
