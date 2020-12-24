package com.course.spring.exceptions;

public class DataBaseException extends RuntimeException {

    public DataBaseException(String message){
        super(message);
    }
}
