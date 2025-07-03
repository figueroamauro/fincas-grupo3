package com.example.fincas_grupo3.domain.models.pago;

import com.example.fincas_grupo3.domain.models.estadoPago.EstadoPago;
import com.example.fincas_grupo3.domain.models.reserva.Reserva;
import java.time.LocalDateTime;

public class Pago {
    private Long id;
    private Double monto;
    private LocalDateTime fecha;
    private EstadoPago estadoPago;
    private Reserva reserva;

    public Pago(Long id, Double monto, LocalDateTime fecha, EstadoPago estadoPago, Reserva reserva) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.estadoPago = estadoPago;
        this.reserva = reserva;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public EstadoPago getEstadoPago() { return estadoPago; }
    public void setEstadoPago(EstadoPago estadoPago) { this.estadoPago = estadoPago; }
    public Reserva getReserva() { return reserva; }
    public void setReserva(Reserva reserva) { this.reserva = reserva; }
}