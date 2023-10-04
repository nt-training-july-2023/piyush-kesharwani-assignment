package com.NTeq.AssessmentPortal.Response;

import lombok.Getter;
import lombok.Setter;
/**
 * A class representing a success response containing a status code and
 * a message.
 */
@Getter
@Setter
public class SuccessResponse {
    /**
     * The HTTP status code indicating the success of the operation.
     */
    private int statusCode;
    /**
     * The message providing additional information about the success.
     */
    private String message;
    /**
     * Constructs a SuccessResponse object with status code and message.
     * @param statusCodes The HTTP status code indicating the success.
     * @param messages    The message providing information about the success.
     */
   public SuccessResponse(final int statusCodes, final String messages) {
       this.statusCode = statusCodes;
       this.message = messages;
   }
}
