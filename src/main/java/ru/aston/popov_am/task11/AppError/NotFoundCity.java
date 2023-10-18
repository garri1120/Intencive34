package ru.aston.popov_am.task11.AppError;

public class NotFoundCity extends Exception{
    public NotFoundCity(String message) {
        super(message);
    }
}
