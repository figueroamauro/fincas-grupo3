package com.example.fincas_grupo3.infrastructure.entities.finca;

import com.example.fincas_grupo3.infrastructure.entities.direccion.DireccionEntidad;
import jakarta.persistence.*;

@Entity
@Table(name = "fincas")
public class FincaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tarifa_hora")
    private Double tarifaHora;

    @Column(name = "tarifa_dia")
    private Double tarifaDia;

    @OneToOne
    private DireccionEntidad direccionEntidad;

    public FincaEntidad() {
    }

    public FincaEntidad(Long id, String nombre, String descripcion, Double tarifaHora, Double tarifaDia, DireccionEntidad direccionEntidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tarifaHora = tarifaHora;
        this.tarifaDia = tarifaDia;
        this.direccionEntidad = direccionEntidad;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(Double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public Double getTarifaDia() {
        return tarifaDia;
    }

    public void setTarifaDia(Double tarifaDia) {
        this.tarifaDia = tarifaDia;
    }

    public DireccionEntidad getDireccionEntidad() {
        return direccionEntidad;
    }

    public void setDireccionEntidad(DireccionEntidad direccionEntidad) {
        this.direccionEntidad = direccionEntidad;
    }
}
