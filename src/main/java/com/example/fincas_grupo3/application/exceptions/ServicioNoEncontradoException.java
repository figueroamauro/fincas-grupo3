package com.example.fincas_grupo3.application.exceptions;

public class ServicioNoEncontradoException extends ObjectNotFoundException {
    public ServicioNoEncontradoException(String message) {
        super(message);
    }
}
