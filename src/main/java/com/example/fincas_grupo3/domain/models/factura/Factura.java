package com.example.fincas_grupo3.domain.models.factura;

import java.time.LocalDateTime;

public class Factura {
    private Long id;
    private String numeroFactura;
    private LocalDateTime fecha;
    private Double precioTotal;

    public Factura(Long id, String numeroFactura, LocalDateTime fecha, Double precioTotal) {
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