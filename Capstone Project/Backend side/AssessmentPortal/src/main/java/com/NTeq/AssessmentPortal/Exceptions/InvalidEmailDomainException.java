package com.NTeq.AssessmentPortal.Exceptions;

public class InvalidEmailDomainException extends RuntimeException {

    /**
    * 
    */
    private static final long serialVersionUID = 1L;

    public InvalidEmailDomainException(String message) {
        super(message);
    }
}
