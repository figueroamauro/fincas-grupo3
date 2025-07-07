package com.example.fincas_grupo3.infrastructure.entities.finca;

import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;
import com.example.fincas_grupo3.infrastructure.entities.direccion.DireccionEntidad;
import com.example.fincas_grupo3.infrastructure.entities.foto.FotoEntidad;
import com.example.fincas_grupo3.infrastructure.entities.horario.HorarioDisponibleEntidad;
import com.example.fincas_grupo3.infrastructure.entities.servicio.ServicioEntidad;
import com.example.fincas_grupo3.infrastructure.entities.tiporeserva.TipoReservaEntidad;
import com.example.fincas_grupo3.infrastructure.entities.usuario.UsuarioEntidad;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "fincas")
public class FincaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tarifa_hora")
    private Double tarifaHora;

    @Column(name = "tarifa_dia")
    private Double tarifaDia;

    @ManyToOne
    @JoinColumn(name = "direccion_id", nullable = false)
    private DireccionEntidad direccion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntidad usuario;

    @ManyToMany
    @JoinTable(
            name = "servicio_ofrecido",
            joinColumns = @JoinColumn(name = "finca_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id")
    )
    private Set<ServicioEntidad> servicios = new HashSet<>();

    @OneToMany(mappedBy = "finca",fetch = FetchType.EAGER)
    private List<HorarioDisponibleEntidad> horarioDisponibleEntidadList;

    @ManyToMany
    @JoinTable(name = "finca_tipo_reserva",
            joinColumns = @JoinColumn(name = "finca_id"),
            inverseJoinColumns = @JoinColumn(name = "tipos_reserva_id"))
    private List<TipoReservaEntidad> tipoReservas;

    @OneToMany(mappedBy = "finca", fetch = FetchType.EAGER)
    private List<FotoEntidad> fotos;


    public FincaEntidad() {
        this.servicios = new HashSet<>();
        this.horarioDisponibleEntidadList = new ArrayList<>();
        this.tipoReservas = new ArrayList<>();
    }

    public FincaEntidad(Long id, String nombre, String descripcion, Double tarifaHora, Double tarifaDia, DireccionEntidad direccion, UsuarioEntidad usuario, Set<ServicioEntidad> servicios) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tarifaHora = tarifaHora;
        this.tarifaDia = tarifaDia;
        this.direccion = direccion;
        this.usuario = usuario;
        this.servicios = servicios;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Double getTarifaHora() { return tarifaHora; }
    public void setTarifaHora(Double tarifaHora) { this.tarifaHora = tarifaHora; }
    public Double getTarifaDia() { return tarifaDia; }
    public void setTarifaDia(Double tarifaDia) { this.tarifaDia = tarifaDia; }
    public DireccionEntidad getDireccion() { return direccion; }
    public void setDireccion(DireccionEntidad direccion) { this.direccion = direccion; }
    public UsuarioEntidad getUsuario() { return usuario; }
    public void setUsuario(UsuarioEntidad usuario) { this.usuario = usuario; }
    public Set<ServicioEntidad> getServicios() { return servicios; }
    public void setServicios(Set<ServicioEntidad> servicios) { this.servicios = servicios; }

    public List<HorarioDisponibleEntidad> getHorarioDisponibleEntidadList() {
        return horarioDisponibleEntidadList;
    }

    public void setHorarioDisponibleEntidadList(List<HorarioDisponibleEntidad> horarioDisponibleEntidadList) {
        this.horarioDisponibleEntidadList = horarioDisponibleEntidadList;
    }

    public List<TipoReservaEntidad> getTipoReservas() {
        return tipoReservas;
    }

    public void setTipoReservas(List<TipoReservaEntidad> tipoReservas) {
        this.tipoReservas = tipoReservas;
    }

    public List<FotoEntidad> getFotos() {
        return fotos;
    }

    public void setFotos(List<FotoEntidad> fotos) {
        this.fotos = fotos;
    }
}