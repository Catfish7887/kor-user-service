package ru.kor.Exceptions.APIexception;

public class APIexception extends Exception{
    private final int code;

    public APIexception(String message, int errorCode){
        super(message);
        this.code = errorCode;
    }

    public int getErrorCode(){
        return this.code;

    }
}
