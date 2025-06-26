package com.example.fincas_grupo3.ciudades.infrastructure.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ciudades")
public class CiudadEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;


    public CiudadEntidad() {}

    public CiudadEntidad(Long id, String nombre) {
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
