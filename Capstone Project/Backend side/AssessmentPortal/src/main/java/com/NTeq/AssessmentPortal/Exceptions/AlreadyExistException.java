package com.NTeq.AssessmentPortal.Exceptions;

/**
 * Custom exception indicating that a AlreadyExistException address was
 * encountered.
 */
public class AlreadyExistException extends RuntimeException {
    /**
     * Serial version UID for serialization/deserialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new AlreadyExist exception with specified error message.
     * @param message The error message indicating the reason for exception.
     */
    public AlreadyExistException(final String message) {
        super(message);
    }

}
