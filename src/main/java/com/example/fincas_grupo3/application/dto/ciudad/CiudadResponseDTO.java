package com.example.fincas_grupo3.application.dto.ciudad;

import com.example.fincas_grupo3.domain.models.provincia.Provincia;

public class CiudadResponseDTO {
    private Long id;
    private String nombre;
    private String nombreProvincia;

    public CiudadResponseDTO(Long id, String nombre, String nombreProvincia) {
        this.id = id;
        this.nombre = nombre;
        this.nombreProvincia = nombreProvincia;
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

    public String getNombreProvincia() {
        return this.nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

}

