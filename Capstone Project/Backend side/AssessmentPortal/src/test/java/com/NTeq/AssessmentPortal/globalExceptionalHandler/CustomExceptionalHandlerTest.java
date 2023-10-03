package com.NTeq.AssessmentPortal.globalExceptionalHandler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.NTeq.AssessmentPortal.Exceptions.AlreadyExistException;
import com.NTeq.AssessmentPortal.Exceptions.DuplicateEmail;
import com.NTeq.AssessmentPortal.Exceptions.ResourceNotFound;
import com.NTeq.AssessmentPortal.Exceptions.WrongCredentialException;
import com.NTeq.AssessmentPortal.Response.ErrorResponse;

class CustomExceptionalHandlerTest {

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testMethodArgumentNotValidException() {
        CustomExceptionalHandler globalException = new CustomExceptionalHandler();
        MethodArgumentNotValidException ex = mock(MethodArgumentNotValidException.class);

        BindingResult bindingResult = mock(BindingResult.class);
        FieldError fieldError = new FieldError("objectName", "fieldName", "message");
        when(bindingResult.getAllErrors()).thenReturn(Collections.singletonList(fieldError));

        when(ex.getBindingResult()).thenReturn(bindingResult);

        ResponseEntity<ErrorResponse> responseEntity = globalException.handleMethodArgumentNotValidException(ex);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("message", responseEntity.getBody().getErrors().get("fieldName"));
    }
    
    @Test
    public void testNoSuchElementException() {
        NoSuchElementException exception = new NoSuchElementException("No such element exits");
        CustomExceptionalHandler exceptionHandler = new CustomExceptionalHandler();
        
        ResponseEntity<ErrorResponse> result = exceptionHandler.handleNoSuchElement(exception);
        assertEquals(HttpStatus.NOT_FOUND , result.getStatusCode());
        assertEquals("No such element exits",result.getBody().getMessage());
    }
    
    @Test
   public void testAlreadyExistException() {
        AlreadyExistException exception = new AlreadyExistException("element already exist");
        CustomExceptionalHandler exceptionHandler = new CustomExceptionalHandler();
        
        ResponseEntity<ErrorResponse> result = exceptionHandler.handleAlreadyExistException(exception);
        assertEquals(HttpStatus.CONFLICT , result.getStatusCode());
        assertEquals("element already exist" , result.getBody().getMessage());
    }

    @Test 
    public void testDuplicateEmail() {
        DuplicateEmail exception = new DuplicateEmail("Email already exists");
        CustomExceptionalHandler exceptionHandler = new CustomExceptionalHandler();
        
        ResponseEntity<ErrorResponse> result = exceptionHandler.handleDuplicateEmail(exception);
        assertEquals(HttpStatus.CONFLICT , result.getStatusCode());
        assertEquals("Email already exists" , result.getBody().getMessage());
    }
    
    @Test
     public void testWrongCredentialException() {
        WrongCredentialException exception = new WrongCredentialException("Invalid Credentials");
        CustomExceptionalHandler exceptionHandler = new CustomExceptionalHandler();
        
        ResponseEntity<ErrorResponse> result = exceptionHandler.handleWrongCredentialException(exception);
        assertEquals(HttpStatus.UNAUTHORIZED , result.getStatusCode());
        assertEquals("Invalid Credentials" , result.getBody().getMessage());
    }
    
    @Test
    public void testResourceNotFound() {
        ResourceNotFound exception = new ResourceNotFound("Resource Not found");
        CustomExceptionalHandler exceptionHandler = new CustomExceptionalHandler();
        
        ResponseEntity<ErrorResponse> result = exceptionHandler.handleResourceNotFound(exception);
        assertEquals(HttpStatus.NOT_FOUND , result.getStatusCode());
        assertEquals("Resource Not found" , result.getBody().getMessage());
    }
}
