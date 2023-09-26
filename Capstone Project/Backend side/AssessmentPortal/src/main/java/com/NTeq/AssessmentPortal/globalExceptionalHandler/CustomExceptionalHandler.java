package com.NTeq.AssessmentPortal.globalExceptionalHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 *Global exception handler controller class.
*/

import com.NTeq.AssessmentPortal.Exceptions.AlreadyExistException;
import com.NTeq.AssessmentPortal.Exceptions.DuplicateEmail;
//import com.NTeq.AssessmentPortal.Exceptions.InvalidEmailDomainException;
import com.NTeq.AssessmentPortal.Exceptions.ResourceNotFound;
import com.NTeq.AssessmentPortal.Exceptions.WrongCredentialException;
@RestControllerAdvice
public class CustomExceptionalHandler {
    /**
     *Exception handles when arguments does not contain valid input.
     *@return errorMap
     *@param exception methodArgumentNotValidException
    */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<Map<String, String>>
    handleMethodArgumentNotValidException(final MethodArgumentNotValidException exp){
        Map<String, String> response = new HashMap<>();
        exp.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            response.put(fieldName, message);
        });
        return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
    }
    /**
     *Exception handles when no element is present with id.
     *@return responseEntity
     *@param exception noSuchElementException
    */
    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<String> handleNoSuchElement(
                final NoSuchElementException exception) {
      return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AlreadyExistException.class)
    public final ResponseEntity<String> handleAlreadyExistException(
            final AlreadyExistException exception) {
    return new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
}
    
    @ExceptionHandler(DuplicateEmail.class)
    public final ResponseEntity<String> handleDuplicateEmail(
            final DuplicateEmail exception) {
     return new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
}
//    
//    @ExceptionHandler(InvalidEmailDomainException.class)
//    public final ResponseEntity<String> handleInvalidEmailDomainException(
//            final InvalidEmailDomainException exception) {
//     return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
//}
    @ExceptionHandler(WrongCredentialException.class)
    public final ResponseEntity<String> handleWrongCredentialException(
            final WrongCredentialException exception) {
     return new ResponseEntity<String>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
}
    @ExceptionHandler(ResourceNotFound.class)
    public final ResponseEntity<String> handleResourceNotFound(
            final ResourceNotFound exception) {
     return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
}
}
