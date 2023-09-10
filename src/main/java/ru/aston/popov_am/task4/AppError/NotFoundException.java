package ru.aston.popov_am.task4.AppError;

public class NotFoundException extends Exception{
    private String message;

    public NotFoundException(String message) {
        super(message);
    }
}
