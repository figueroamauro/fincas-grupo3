package com.example.fincas_grupo3.application.dto.publicacion;

import java.util.Date;

public class PublicacionRequestDTO {
    private Long id;
    private String titulo;
    private String descripcion;

    public PublicacionRequestDTO() {}

    public PublicacionRequestDTO(Long id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
