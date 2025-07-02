package com.example.fincas_grupo3.domain.models.reserva;

import com.example.fincas_grupo3.domain.models.estadoreserva.EstadoReserva;

import java.time.LocalDateTime;

public class Reserva {
    private Long id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Double precioTotal;
    private EstadoReserva estadoReserva;

    public Reserva(Long id, LocalDateTime fechaInicio, LocalDateTime fechaFin, Double precioTotal, EstadoReserva estadoReserva) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioTotal = precioTotal;
        this.estadoReserva = estadoReserva;
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

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
}