package com.example.fincas_grupo3.application.dto.estadopublicacion;


public class EstadoPublicacionResponseDTO {
    private Long id;
    private String nombre;


    public EstadoPublicacionResponseDTO() {}

    public EstadoPublicacionResponseDTO(Long id, String nombre) {
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
