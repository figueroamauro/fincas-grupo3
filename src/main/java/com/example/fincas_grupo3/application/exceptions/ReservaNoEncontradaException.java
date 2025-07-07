package com.example.fincas_grupo3.application.exceptions;

public class ReservaNoEncontradaException extends ObjectNotFoundException {
    public ReservaNoEncontradaException(String message) {
        super(message);
    }
}