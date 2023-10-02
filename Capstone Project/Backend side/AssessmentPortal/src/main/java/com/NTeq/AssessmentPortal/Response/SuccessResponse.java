package com.NTeq.AssessmentPortal.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponse {
   private int statusCode;
   private String message;
   
   public SuccessResponse(int statusCode , String message) {
       this.statusCode = statusCode;
       this.message = message;
   }
}
