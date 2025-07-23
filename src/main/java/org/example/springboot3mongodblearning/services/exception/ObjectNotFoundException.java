package org.example.springboot3mongodblearning.services.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
