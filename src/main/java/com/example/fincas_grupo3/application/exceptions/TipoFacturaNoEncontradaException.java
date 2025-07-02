package com.example.fincas_grupo3.application.exceptions;

public class TipoFacturaNoEncontradaException extends ObjectNotFoundException {
    public TipoFacturaNoEncontradaException(String message) {
        super(message);
    }
}
