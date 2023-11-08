package com.NTeq.AssessmentPortal.Response;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Represents an error response containing status code, message, errors map.
 */
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
     * Gets the HTTP status code of the API response.
     * @return The HTTP status code.
     */
    public int getStatusCode() {
        return statusCode;
    }
    /**
     * Sets the HTTP status code of the API response.
     * @param statusCodes The HTTP status code to be set.
     */
    public void setStatusCode(final int statusCodes) {
        this.statusCode = statusCodes;
    }
    /**
     * Gets the descriptive message accompanying the API response.
     * @return The descriptive message.
     */
    public String getMessage() {
        return message;
    }
    /**
     * Sets the descriptive message accompanying the API response.
     * @param messages The descriptive message to be set.
     */
    public void setMessage(final String messages) {
        this.message = messages;
    }
    /**
     * Gets the map containing field names as keys and corresponding error
     *  messages as values.
     * @return An unmodifiable map of errors, or null if there are no errors.
     */
    public Map<String, String> getErrors() {
        return errors != null ? Collections.unmodifiableMap(errors) : null;
    }
    /**
     * Sets the errors map containing field names as keys and
     * corresponding error messages as values.
     * @param inputErrors The map of errors to be set.
     * Pass null to clear the existing errors.
     */
    public void setErrors(final Map<String, String> inputErrors) {
        this.errors = inputErrors != null ? new HashMap<>(inputErrors) : null;
    }
    /**
     * Constructs an ErrorResponse with the given status code and errors map.
     * @param statusCodes The HTTP status code indicating the type of error.
     * @param error A map containing specific error details.
     */
    public ErrorResponse(final int statusCodes,
            final Map<String, String> error) {
        this.statusCode = statusCodes;
        this.errors = error != null ? new HashMap<>(error) : null;
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
