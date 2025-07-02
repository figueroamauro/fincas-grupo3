package com.example.fincas_grupo3.application.dto.estadopublicacion;

public class EstadoPublicacionRequestDTO {
    private Long id;
    private String nombre;

    public EstadoPublicacionRequestDTO() {}

    public EstadoPublicacionRequestDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
