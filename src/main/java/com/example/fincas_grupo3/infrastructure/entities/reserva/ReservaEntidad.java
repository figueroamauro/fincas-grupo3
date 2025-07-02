package com.example.fincas_grupo3.infrastructure.entities.reserva;

import com.example.fincas_grupo3.infrastructure.entities.estadoreserva.EstadoReservaEntidad;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
public class ReservaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDateTime fechaFin;

    @Column(name = "precio_total")
    private Double precioTotal;

    @ManyToOne
    @JoinColumn(name = "estado_id", referencedColumnName = "id", nullable = false)
    private EstadoReservaEntidad estadoReservaEntidad;


    public ReservaEntidad() {
    }

    public ReservaEntidad(Long id, LocalDateTime fechaInicio, LocalDateTime fechaFin, Double precioTotal, EstadoReservaEntidad estadoReservaEntidad) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioTotal = precioTotal;
        this.estadoReservaEntidad = estadoReservaEntidad;
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

    public EstadoReservaEntidad getEstadoReservaEntidad() {
        return estadoReservaEntidad;
    }

    public void setEstadoReservaEntidad(EstadoReservaEntidad estadoReservaEntidad) {
        this.estadoReservaEntidad = estadoReservaEntidad;
    }
}