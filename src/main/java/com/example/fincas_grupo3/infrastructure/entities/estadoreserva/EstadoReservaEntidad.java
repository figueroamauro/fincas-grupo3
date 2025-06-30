package com.example.fincas_grupo3.infrastructure.entities.estadoreserva;

import jakarta.persistence.*;

@Entity
@Table(name = "estados_reserva")
public class EstadoReservaEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    public EstadoReservaEntidad() {}

    public EstadoReservaEntidad(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}