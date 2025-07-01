package com.example.fincas_grupo3.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class FacturaNoEncontradaException extends RuntimeException {
    public FacturaNoEncontradaException(String message) {
        super(message);
    }
}