package com.example.fincas_grupo3.application.dto.finca;

import com.example.fincas_grupo3.application.dto.direccion.DireccionResponseDTO;

public class FincaResponseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double tarifaHora;
    private Double tarifaDia;
    private DireccionResponseDTO direccionResponseDTO;

    public FincaResponseDTO(Long id, String nombre, String descripcion, Double tarifaHora, Double tarifaDia, DireccionResponseDTO direccionResponseDTO) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tarifaHora = tarifaHora;
        this.tarifaDia = tarifaDia;
        this.direccionResponseDTO = direccionResponseDTO;
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

    public DireccionResponseDTO getDireccionResponseDTO() {
        return direccionResponseDTO;
    }

    public void setDireccionResponseDTO(DireccionResponseDTO direccionResponseDTO) {
        this.direccionResponseDTO = direccionResponseDTO;
    }
}
