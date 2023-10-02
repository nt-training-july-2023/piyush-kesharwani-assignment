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
import com.NTeq.AssessmentPortal.Exceptions.AlreadyExistException;
import com.NTeq.AssessmentPortal.Exceptions.DuplicateEmail;
import com.NTeq.AssessmentPortal.Exceptions.ResourceNotFound;
import com.NTeq.AssessmentPortal.Exceptions.WrongCredentialException;
import com.NTeq.AssessmentPortal.Response.ErrorResponse;

/**
 * Global exception handler controller class.
 */
@RestControllerAdvice
public class CustomExceptionalHandler {
    /**
     * Exception handles when arguments does not contain valid input.
     * @return errorMap
     * @param exp methodArgumentNotValidException
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorResponse>
        handleMethodArgumentNotValidException(
                final MethodArgumentNotValidException exp) {
        Map<String, String> response = new HashMap<>();
        exp.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            response.put(fieldName, message);
        });
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                response);
        return new ResponseEntity<ErrorResponse>(errorResponse,
                HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception handles when no element is present with id.
     * @return responseEntity
     * @param exception noSuchElementException
     */
    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<ErrorResponse> handleNoSuchElement(
            final NoSuchElementException exception) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage());
        return new ResponseEntity<ErrorResponse>(response,
                HttpStatus.NOT_FOUND);
    }
    /**
     * Exception handler for handling AlreadyExistException.
     * @param exception AlreadyExistException.
     * @return ResponseEntity containing error message.
     */
    @ExceptionHandler(AlreadyExistException.class)
    public final ResponseEntity<ErrorResponse> handleAlreadyExistException(
            final AlreadyExistException exception) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                exception.getMessage());
        return new ResponseEntity<ErrorResponse>(response,
                HttpStatus.CONFLICT);
    }
    /**
     * Exception handler for handling DuplicateEmail.
     * @param exception DuplicateEmail.
     * @return ResponseEntity containing error message.
     */
    @ExceptionHandler(DuplicateEmail.class)
    public final ResponseEntity<ErrorResponse> handleDuplicateEmail(
            final DuplicateEmail exception) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                exception.getMessage());
        return new ResponseEntity<ErrorResponse>(response,
                HttpStatus.CONFLICT);
    }
    /**
     * Exception handler for handling WrongCredentialException.
     * @param exception WrongCredentialException.
     * @return ResponseEntity containing error message.
     */
    @ExceptionHandler(WrongCredentialException.class)
    public final ResponseEntity<ErrorResponse> handleWrongCredentialException(
            final WrongCredentialException exception) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.UNAUTHORIZED.value(),
                exception.getMessage());
        return new ResponseEntity<ErrorResponse>(response,
                HttpStatus.UNAUTHORIZED);
    }
    /**
     * Exception handler for handling ResourceNotFound.
     * @param exception ResourceNotFound.
     * @return ResponseEntity containing error message.
     */
    @ExceptionHandler(ResourceNotFound.class)
    public final ResponseEntity<ErrorResponse> handleResourceNotFound(
            final ResourceNotFound exception) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage());
        return new ResponseEntity<ErrorResponse>(response,
                HttpStatus.NOT_FOUND);
    }
}
