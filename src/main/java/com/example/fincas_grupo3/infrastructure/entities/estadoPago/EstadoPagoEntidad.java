package com.example.fincas_grupo3.infrastructure.entities.estadoPago;

import jakarta.persistence.*;

@Entity
@Table(name = "estados_pago")
public class EstadoPagoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    public EstadoPagoEntidad() {}

    public EstadoPagoEntidad(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}