package com.example.fincas_grupo3.ciudades.application.dto;

public class CiudadResponseDTO {
    private Long id;
    private String nombre;


    public CiudadResponseDTO(Long id, String nombre) {
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

