package com.example.fincas_grupo3.application.dto.ciudad;

import com.example.fincas_grupo3.domain.models.provincia.Provincia;

public class CiudadRequestDTO {
    private Long id;
    private String nombre;
    private Long provinciaId;

    public CiudadRequestDTO(Long id, String nombre, Long provinciaId) {
        this.id = id;
        this.nombre = nombre;
        this.provinciaId = provinciaId;
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

    public Long getProvinciaId() {
        return this.provinciaId;
    }

    public void setProvinciaId(Long provinciaId) {
        this.provinciaId = provinciaId;
    }


}

