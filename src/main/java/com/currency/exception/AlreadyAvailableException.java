package com.currency.exception;

public class AlreadyAvailableException extends RuntimeException{

public AlreadyAvailableException(String message) {
    super(message);

}
    public AlreadyAvailableException(String message, Throwable cause) {
        super(message, cause);
}}
