package com.example.fincas_grupo3.domain.models.pago;

import java.time.LocalDateTime;

public class Pago {
    private Long id;
    private Double monto;
    private LocalDateTime fecha;

    public Pago(Long id, Double monto, LocalDateTime fecha) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
    }

    // Getters y Setters
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