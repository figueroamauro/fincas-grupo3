package com.example.fincas_grupo3.infrastructure.entities.pago;

import com.example.fincas_grupo3.infrastructure.entities.estadoPago.EstadoPagoEntidad;
import com.example.fincas_grupo3.infrastructure.entities.reserva.ReservaEntidad;
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

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private EstadoPagoEntidad estadoPago;

    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private ReservaEntidad reserva;


    public PagoEntidad() {}


    public PagoEntidad(Long id, Double monto, LocalDateTime fecha, EstadoPagoEntidad estadoPago, ReservaEntidad reserva) {
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
    public EstadoPagoEntidad getEstadoPago() { return estadoPago; }
    public void setEstadoPago(EstadoPagoEntidad estadoPago) { this.estadoPago = estadoPago; }
    public ReservaEntidad getReserva() { return reserva; }
    public void setReserva(ReservaEntidad reserva) { this.reserva = reserva; }
}