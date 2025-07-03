package com.example.fincas_grupo3.application.dto.reserva;

import java.time.LocalDateTime;

public class ReservaRequestDTO {
    private Long id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Double precioTotal;
    private Long estadoId;
    private Long usuarioId;
    private Long fincaId;
    private Long tipoReservaId;



    public ReservaRequestDTO(Long id, LocalDateTime fechaInicio, LocalDateTime fechaFin, Double precioTotal, Long estadoId, Long usuarioId, Long fincaId, Long tipoReservaId) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioTotal = precioTotal;
        this.estadoId = estadoId;
        this.usuarioId = usuarioId;
        this.fincaId = fincaId;
        this.tipoReservaId = tipoReservaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getFincaId() {
        return fincaId;
    }

    public void setFincaId(Long fincaId) {
        this.fincaId = fincaId;
    }

    public Long getTipoReservaId() {
        return tipoReservaId;
    }

    public void setTipoReservaId(Long tipoReservaId) {
        this.tipoReservaId = tipoReservaId;
    }
}