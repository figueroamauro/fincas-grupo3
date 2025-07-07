package com.example.fincas_grupo3.infrastructure.entities.ciudad;

import com.example.fincas_grupo3.infrastructure.entities.provincia.ProvinciaEntidad;
import jakarta.persistence.*;

@Entity
@Table(name = "ciudades")
public class CiudadEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;


    @ManyToOne
    @JoinColumn(name = "provincia_id", referencedColumnName = "id", nullable = false)
    private ProvinciaEntidad provincia;

    public CiudadEntidad() {}


    public CiudadEntidad(Long id, String nombre, ProvinciaEntidad provincia) {
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

    public ProvinciaEntidad getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaEntidad provincia) {
        this.provincia = provincia;
    }
}
