package com.example.fincas_grupo3.application.exceptions.handler;

import com.example.fincas_grupo3.application.exceptions.CorreoYaRegistradoException;
import com.example.fincas_grupo3.application.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Map<String,String>> handlerNotFound(Exception e) {
        Map<String, String> error = new HashMap<>();

        error.put("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler({CorreoYaRegistradoException.class,
    IllegalArgumentException.class})
    public ResponseEntity<Map<String,String>> handlerBadRequest(Exception e) {
        Map<String, String> error = new HashMap<>();

        error.put("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
