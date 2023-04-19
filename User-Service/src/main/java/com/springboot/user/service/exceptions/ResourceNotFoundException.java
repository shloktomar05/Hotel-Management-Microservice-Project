package com.springboot.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String s){
        super("Resource not found on server");
    }
}
