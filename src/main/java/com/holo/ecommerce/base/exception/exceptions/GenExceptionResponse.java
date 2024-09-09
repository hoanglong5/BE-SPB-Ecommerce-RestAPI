package com.holo.ecommerce.base.exception.exceptions;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.config.auth.exception.AuthenticationExceptionResponse;
import com.holo.ecommerce.config.auth.exception.WrongCredentialException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@RestControllerAdvice
public class GenExceptionResponse{
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Object> HandleItemNotFoundExceptions (Exception ex, WebRequest webRequest){
        LocalDate errorTime = LocalDate.now();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);
        boolean isSuccess = false;
        ExceptionResponse exceptionResponse = new ExceptionResponse(errorTime,message,description,isSuccess);
        RestResponse<ExceptionResponse> response = RestResponse.error(exceptionResponse);
        response.setMessages(message);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(WrongCredentialException.class)
    public ResponseEntity<Object> HandleWrongCredentialException (Exception ex, WebRequest webRequest){
        LocalDate errorTime = LocalDate.now();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);
        boolean isAuthenticate = false;
        boolean isSuccess = false;
        AuthenticationExceptionResponse exceptionResponse = new AuthenticationExceptionResponse(isAuthenticate,errorTime,message,description,isSuccess);
        RestResponse<AuthenticationExceptionResponse> response = RestResponse.error(exceptionResponse);
        response.setMessages(message);
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
