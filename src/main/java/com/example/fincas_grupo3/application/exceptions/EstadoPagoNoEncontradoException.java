package com.example.fincas_grupo3.application.exceptions;

public class EstadoPagoNoEncontradoException extends ObjectNotFoundException {
    public EstadoPagoNoEncontradoException(String message) {
        super(message);
    }
}
