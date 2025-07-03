package com.example.fincas_grupo3.application.dto.finca;

public class FincaRequestDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double tarifaHora;
    private Double tarifaDia;
    private Long direccionId;
    private Long usuarioId;

    public FincaRequestDTO(Long id, String nombre, String descripcion, Double tarifaHora, Double tarifaDia, Long direccionId, Long usuarioId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tarifaHora = tarifaHora;
        this.tarifaDia = tarifaDia;
        this.direccionId = direccionId;
        this.usuarioId = usuarioId;
    }

    // Getters y Setters
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

    public Long getDireccionId() {
        return direccionId;
    }

    public void setDireccionId(Long direccionId) {
        this.direccionId = direccionId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}