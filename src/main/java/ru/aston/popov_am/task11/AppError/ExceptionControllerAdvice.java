package ru.aston.popov_am.task11.AppError;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<?> handlerNotFoundCity(NotFoundCity notFoundCity) {
    return ResponseEntity.ok(notFoundCity.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<?> handlerNonExistentExchangeRate(NonExistentExchangeRate nonExistentExchangeRate) {
        return ResponseEntity.ok(nonExistentExchangeRate.getMessage());
    }
}
