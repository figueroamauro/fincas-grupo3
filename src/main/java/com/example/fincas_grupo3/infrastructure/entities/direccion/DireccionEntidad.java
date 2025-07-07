package com.example.fincas_grupo3.infrastructure.entities.direccion;

import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;
import com.example.fincas_grupo3.infrastructure.entities.ciudad.CiudadEntidad;
import jakarta.persistence.*;

@Entity
@Table(name = "direcciones")
public class DireccionEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "calle", nullable = false)
    private String calle;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "codigo_postal", nullable = false)
    private String codigoPostal;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private CiudadEntidad ciudadEntidad;


    public DireccionEntidad() {
    }

    public DireccionEntidad(Long id, String calle, String numero, String codigoPostal, CiudadEntidad ciudadEntidad) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudadEntidad = ciudadEntidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public CiudadEntidad getCiudadEntidad() {
        return ciudadEntidad;
    }

    public void setCiudadEntidad(CiudadEntidad ciudadEntidad) {
        this.ciudadEntidad = ciudadEntidad;
    }
}
