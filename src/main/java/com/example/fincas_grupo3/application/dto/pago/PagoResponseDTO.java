package com.example.fincas_grupo3.application.dto.pago;

import com.example.fincas_grupo3.application.dto.reserva.ReservaResponseDTO;
import java.time.LocalDateTime;

public class PagoResponseDTO {
    private Long id;
    private Double monto;
    private LocalDateTime fecha;
    private String nombreEstado;
    private ReservaResponseDTO reserva;

    public PagoResponseDTO(Long id, Double monto, LocalDateTime fecha, String nombreEstado, ReservaResponseDTO reserva) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.nombreEstado = nombreEstado;
        this.reserva = reserva;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public String getNombreEstado() { return nombreEstado; }
    public void setNombreEstado(String nombreEstado) { this.nombreEstado = nombreEstado; }
    public ReservaResponseDTO getReserva() { return reserva; }
    public void setReserva(ReservaResponseDTO reserva) { this.reserva = reserva; }
}