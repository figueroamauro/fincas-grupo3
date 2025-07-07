package com.example.fincas_grupo3.application.exceptions;

public class CiudadNoEncontradaException extends ObjectNotFoundException {
    public CiudadNoEncontradaException(String message) {
        super(message);
    }
}
