package com.example.fincas_grupo3.application.exceptions;

public class TipoReservaNoEncontradoException extends ObjectNotFoundException {
    public TipoReservaNoEncontradoException(String message) {
        super(message);
    }
}