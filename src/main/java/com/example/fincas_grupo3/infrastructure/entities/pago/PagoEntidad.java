package com.example.fincas_grupo3.infrastructure.entities.pago;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
public class PagoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto", nullable = false)
    private Double monto;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;


    public PagoEntidad() {}

    public PagoEntidad(Long id, Double monto, LocalDateTime fecha) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}