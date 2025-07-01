package com.example.fincas_grupo3.application.dto.ciudad;

import com.example.fincas_grupo3.domain.models.provincia.Provincia;

public class CiudadRequestDTO {
    private Long id;
    private String nombre;
    private Long provincia_id;

    public CiudadRequestDTO(Long id, String nombre, Long provincia_id) {
        this.id = id;
        this.nombre = nombre;
        this.provincia_id = provincia_id;
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
        return this.provincia_id;
    }

    public void setProvinciaId(Long provincia_id) {
        this.provincia_id = provincia_id;
    }


}

