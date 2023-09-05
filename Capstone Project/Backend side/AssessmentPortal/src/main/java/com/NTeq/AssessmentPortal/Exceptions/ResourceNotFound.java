package com.NTeq.AssessmentPortal.Exceptions;
/**
 * Exception indicating an Resource not found.
 */
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
