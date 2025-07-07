package com.example.fincas_grupo3.application.exceptions;

public class HorarioNoEncontradoException extends ObjectNotFoundException {
    public HorarioNoEncontradoException(String message) {
        super(message);
    }
}
