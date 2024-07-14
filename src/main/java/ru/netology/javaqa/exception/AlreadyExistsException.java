package ru.netology.javaqa.exception;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(String s){
        super(s);
    }
}