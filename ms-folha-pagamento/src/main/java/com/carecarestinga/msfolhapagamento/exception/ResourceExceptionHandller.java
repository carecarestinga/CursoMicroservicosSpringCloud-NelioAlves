package com.carecarestinga.msfolhapagamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandller {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ValidationError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ValidationError error = new ValidationError(Instant.now(), status.value(), "Recurso nao Encontrado",
                e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }
}
