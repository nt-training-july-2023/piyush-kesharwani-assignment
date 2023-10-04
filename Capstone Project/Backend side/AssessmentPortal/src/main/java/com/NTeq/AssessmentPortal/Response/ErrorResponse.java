package com.NTeq.AssessmentPortal.Response;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
/**
 * Represents an error response containing status code, message, errors map.
 */
@Getter
@Setter
public class ErrorResponse {
    /**
     * The HTTP status code indicating the type of error.
     */
    private int statusCode;
    /**
     * The descriptive error message.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    /**
     * A map containing specific error details.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> errors;
    /**
     * Constructs an ErrorResponse with the given status code and errors map.
     * @param statusCodes The HTTP status code indicating the type of error.
     * @param error A map containing specific error details.
     */
    public ErrorResponse(final int statusCodes,
            final Map<String, String> error) {
        this.statusCode = statusCodes;
        this.errors = error;
    }
    /**
     * Constructs an ErrorResponse with the given status code and message.
     * @param statusCodes The HTTP status code indicating the type of error.
     * @param messages The descriptive error message.
     */
    public ErrorResponse(final int statusCodes, final String messages) {
        this.statusCode = statusCodes;
        this.message = messages;
    }
}
