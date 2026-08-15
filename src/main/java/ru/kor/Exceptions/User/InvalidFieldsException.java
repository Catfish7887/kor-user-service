package ru.kor.Exceptions.User;

public class InvalidFieldsException extends Exception{

    public InvalidFieldsException() {
        super();
    }

    public InvalidFieldsException(String message) {
        super(message);
    }
    
}
