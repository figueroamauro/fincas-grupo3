package com.example.fincas_grupo3.application.dto.pago;

import java.time.LocalDateTime;

public class PagoResponseDTO {
    private Long id;
    private Double monto;
    private LocalDateTime fecha;

    public PagoResponseDTO(Long id, Double monto, LocalDateTime fecha) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getMonto() {
        return monto;
    }
    public void setMonto(Double monto) {
        this.monto = monto;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}