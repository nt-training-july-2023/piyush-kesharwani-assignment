package com.NTeq.AssessmentPortal.Exceptions;
/**
 * Exception indicating wrong credentials provided.
 */
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
