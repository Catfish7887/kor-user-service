package ru.kor.Utils.Exceptions;

public abstract class AppException extends Exception {

    private final ErrorCode code;

    public AppException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public ErrorCode getCode() {
        return this.code;
    }
}
