package ru.aston.popov_am.task4.AppError;

public class InvalidDataException extends Exception{
    private String message;

    public InvalidDataException(String message) {
        super(message);
    }
}
