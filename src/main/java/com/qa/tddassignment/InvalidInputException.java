package com.qa.tddassignment;

public class InvalidInputException extends Throwable {

    private String message;

    public InvalidInputException(String msg){

        message=msg;
    }
    public String getMessage(){

        return message;
    }
}
