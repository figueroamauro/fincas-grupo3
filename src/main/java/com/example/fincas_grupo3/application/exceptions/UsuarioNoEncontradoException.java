package com.example.fincas_grupo3.application.exceptions;

public class UsuarioNoEncontradoException extends ObjectNotFoundException {
    public UsuarioNoEncontradoException(String message) {
        super(message);
    }
}
