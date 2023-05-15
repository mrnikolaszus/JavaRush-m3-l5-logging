package org.example.exceptions;

public class UserServiceException extends RuntimeException{
    public UserServiceException(String msg){
        super(msg);
    }
}
