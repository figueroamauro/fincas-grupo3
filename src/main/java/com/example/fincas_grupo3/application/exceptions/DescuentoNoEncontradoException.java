package com.example.fincas_grupo3.application.exceptions;

public class DescuentoNoEncontradoException extends ObjectNotFoundException {
    public DescuentoNoEncontradoException(String message) {
        super(message);
    }
}
