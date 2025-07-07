package com.example.fincas_grupo3.infrastructure.entities.estadopublicacion;

import jakarta.persistence.*;

@Entity
@Table(name = "estadopublicacion")
public class EstadoPublicacionEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;


    public EstadoPublicacionEntidad() {
    }

    public EstadoPublicacionEntidad(Long id, String nombre) {
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
