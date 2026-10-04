package com.library.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<?> badRequest(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(java.util.Map.of("error", e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
ResponseEntity<?> serverError(Exception e) {
    e.printStackTrace();
    return ResponseEntity.status(500)
            .body(java.util.Map.of("error", e.getMessage()));
}
    }
