package com.tutoria.semana10.error;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno do servidor", e.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(ChangeSetPersister.NotFoundException e) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, "Recurso não encontrado", e.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    private static class ApiError {
        private HttpStatus status;
        private String error;
        private String message;

        public ApiError(HttpStatus status, String error, String message) {
            this.status = status;
            this.error = error;
            this.message = message;
        }

    }
}

