package com.holo.ecommerce.config.auth.exception;

public class WrongCredentialException extends RuntimeException{
    public WrongCredentialException(String message){
        super(message);
    }
}
