package com.example.fincas_grupo3.application.exceptions;

public class CorreoYaRegistradoException extends RuntimeException {
    public CorreoYaRegistradoException(String message) {
        super(message);
    }
}
