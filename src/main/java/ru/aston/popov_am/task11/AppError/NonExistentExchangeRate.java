package ru.aston.popov_am.task11.AppError;

public class NonExistentExchangeRate extends Exception{
    public NonExistentExchangeRate(String message) {
        super(message);
    }
}
