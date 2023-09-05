package com.NTeq.AssessmentPortal.Exceptions;

/**
 * Exception indicating required fields are missing.
 */
public class FieldsRequiredException extends RuntimeException {

    /**
     * Serial version UID for serialization/deserialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new FieldsRequiredException.
     * @param message The error message indicating missing fields.
     */
    public FieldsRequiredException(final String message) {
        super(message);
    }
}
