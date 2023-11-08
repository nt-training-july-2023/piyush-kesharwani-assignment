package com.NTeq.AssessmentPortal.Response;

import java.util.Objects;

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
   /**
    * @param o object of class stored here.
    * @return it return true if object matches.
    */
   @Override
   public boolean equals(final Object o) {
       if (this == o) {
           return true;
       }
       if (o == null || getClass() != o.getClass()) {
           return false;
       }
       SuccessResponse response = (SuccessResponse) o;
       return statusCode == response.statusCode
               && Objects.equals(message, response.message);
   }
   /**
    * Returns a hash code value for this Response based on its HTTP status
    * code and message.
    * @return A hash code value for this SuccessResponse.
    */
   @Override
   public int hashCode() {
       return Objects.hash(statusCode, message);
   }
}
