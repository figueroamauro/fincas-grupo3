package com.example.fincas_grupo3.domain.models.ciudad;

import com.example.fincas_grupo3.domain.models.provincia.Provincia;

public class Ciudad {
    private Long id;
    private String nombre;
    private Provincia provincia;

    public Ciudad(Long id, String nombre, Provincia provincia) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
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

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}