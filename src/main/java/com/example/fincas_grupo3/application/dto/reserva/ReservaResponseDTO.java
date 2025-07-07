package com.example.fincas_grupo3.application.dto.reserva;

import com.example.fincas_grupo3.application.dto.finca.FincaResponseDTO;
import com.example.fincas_grupo3.application.dto.usuario.UsuarioResponseDTO;

import java.time.LocalDateTime;

public class ReservaResponseDTO {
    private Long id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Double precioTotal;
    private String nombreEstado;
    private String nombreTipoReserva;
    private UsuarioResponseDTO usuario;
    private FincaResponseDTO finca;



    public ReservaResponseDTO(Long id, LocalDateTime fechaInicio, LocalDateTime fechaFin, Double precioTotal, String nombreEstado, String nombreTipoReserva, UsuarioResponseDTO usuario, FincaResponseDTO finca) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioTotal = precioTotal;
        this.nombreEstado = nombreEstado;
        this.nombreTipoReserva = nombreTipoReserva;
        this.usuario = usuario;
        this.finca = finca;
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

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public String getNombreTipoReserva() {
        return nombreTipoReserva;
    }

    public void setNombreTipoReserva(String nombreTipoReserva) {
        this.nombreTipoReserva = nombreTipoReserva;
    }

    public UsuarioResponseDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioResponseDTO usuario) {
        this.usuario = usuario;
    }

    public FincaResponseDTO getFinca() {
        return finca;
    }

    public void setFinca(FincaResponseDTO finca) {
        this.finca = finca;
    }
}