package com.example.fincas_grupo3.application.exceptions;


public class PagoNoEncontradoException extends RuntimeException {
    public PagoNoEncontradoException(String message) {
        super(message);
    }
}