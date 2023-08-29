package com.NTeq.AssessmentPortal.Exceptions;

public class WrongCredentialException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public WrongCredentialException(String message) {
        super(message);
    }
}
