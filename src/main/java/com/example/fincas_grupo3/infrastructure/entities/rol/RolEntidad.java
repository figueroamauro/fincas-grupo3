package com.example.fincas_grupo3.infrastructure.entities.rol;
import jakarta.persistence.*;




@Entity
@Table(name = "roles")
public class RolEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre",nullable = false)
    private String nombre;

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

    public RolEntidad(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;

    }
    public RolEntidad() {
    }
}
