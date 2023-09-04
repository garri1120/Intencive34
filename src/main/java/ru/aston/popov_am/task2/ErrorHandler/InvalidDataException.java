package ru.aston.popov_am.task2.ErrorHandler;

public class InvalidDataException extends Exception{
    private final Integer errorCode;
    public InvalidDataException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode.getCode();
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
