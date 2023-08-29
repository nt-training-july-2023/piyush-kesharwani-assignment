package com.NTeq.AssessmentPortal.Exceptions;

public class FieldsRequiredException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public FieldsRequiredException(String message) {
        super(message);
    }
}
