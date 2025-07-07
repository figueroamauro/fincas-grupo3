package com.example.fincas_grupo3.infrastructure.entities.factura;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
public class FacturaEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_factura", nullable = false, unique = true)
    private String numeroFactura;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "precio_total", nullable = false)
    private Double precioTotal;


    public FacturaEntidad() {}

    public FacturaEntidad(Long id, String numeroFactura, LocalDateTime fecha, Double precioTotal) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }
}