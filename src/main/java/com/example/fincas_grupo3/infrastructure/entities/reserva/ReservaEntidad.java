package com.example.fincas_grupo3.infrastructure.entities.reserva;

import com.example.fincas_grupo3.infrastructure.entities.estadoreserva.EstadoReservaEntidad;
import com.example.fincas_grupo3.infrastructure.entities.finca.FincaEntidad;
import com.example.fincas_grupo3.infrastructure.entities.tiporeserva.TipoReservaEntidad;
import com.example.fincas_grupo3.infrastructure.entities.usuario.UsuarioEntidad;
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

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private UsuarioEntidad usuario;

    @ManyToOne
    @JoinColumn(name = "finca_id", referencedColumnName = "id", nullable = false)
    private FincaEntidad finca;

    @ManyToOne
    @JoinColumn(name = "tipo_reserva_id", referencedColumnName = "id", nullable = false)
    private TipoReservaEntidad tipoReserva;



    public ReservaEntidad() {
    }

    public ReservaEntidad(Long id, LocalDateTime fechaInicio, LocalDateTime fechaFin, Double precioTotal, EstadoReservaEntidad estadoReservaEntidad, UsuarioEntidad usuario, FincaEntidad finca, TipoReservaEntidad tipoReserva) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioTotal = precioTotal;
        this.estadoReservaEntidad = estadoReservaEntidad;
        this.usuario = usuario;
        this.finca = finca;
        this.tipoReserva = tipoReserva;
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

    public UsuarioEntidad getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntidad usuario) {
        this.usuario = usuario;
    }

    public FincaEntidad getFinca() {
        return finca;
    }

    public void setFinca(FincaEntidad finca) {
        this.finca = finca;
    }

    public TipoReservaEntidad getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReservaEntidad tipoReserva) {
        this.tipoReserva = tipoReserva;
    }
}