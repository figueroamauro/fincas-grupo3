package com.example.fincas_grupo3.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Esto hará que Spring devuelva un 404 automáticamente
public class PublicacionNoEncontradaException extends RuntimeException {
    public PublicacionNoEncontradaException(String message) {
        super(message);
    }
}