package com.example.fincas_grupo3.application.dto.pago;

import java.time.LocalDateTime;

public class PagoRequestDTO {
    private Long id;
    private Double monto;
    private LocalDateTime fecha;
    private Long estadoId;
    private Long reservaId;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public Long getEstadoId() { return estadoId; }
    public void setEstadoId(Long estadoId) { this.estadoId = estadoId; }
    public Long getReservaId() { return reservaId; }
    public void setReservaId(Long reservaId) { this.reservaId = reservaId; }
}