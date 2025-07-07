package com.example.fincas_grupo3.domain.models.finca;

import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import com.example.fincas_grupo3.domain.models.foto.Foto;
import com.example.fincas_grupo3.domain.models.horario.HorarioDisponible;
import com.example.fincas_grupo3.domain.models.servicio.Servicio;
import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;
import com.example.fincas_grupo3.domain.models.usuario.Usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Finca {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double tarifaHora;
    private Double tarifaDia;
    private Direccion direccion;
    private Usuario usuario;
    private Set<Servicio> servicios;
    private List<HorarioDisponible> horarioDisponibleList;
    private Set<TipoReserva> tipoReservas;
    private List<Foto> fotos;

    public Finca() {
        this.servicios = new HashSet<>();
        this.horarioDisponibleList = new ArrayList<>();
        this.tipoReservas = new HashSet<>();
        this.fotos = new ArrayList<>();
    }

    public Finca(Long id, String nombre, String descripcion, Double tarifaHora, Double tarifaDia, Direccion direccion, Usuario usuario, Set<Servicio> servicios) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tarifaHora = tarifaHora;
        this.tarifaDia = tarifaDia;
        this.direccion = direccion;
        this.usuario = usuario;
        this.servicios = servicios;
    }

    public void agregarHorario(HorarioDisponible horarioDisponible) {
        validarHorarios(horarioDisponible);
        this.horarioDisponibleList.add(horarioDisponible);
    }

    private void validarHorarios(HorarioDisponible horarioDisponible) {
        validarHorarioExistente(horarioDisponible);
    }

    private void validarHorarioExistente(HorarioDisponible horarioDisponible) {
        for (HorarioDisponible horarioActual : this.horarioDisponibleList) {
            if (horarioActual.getDiaSemana() == horarioDisponible.getDiaSemana()) {
                if (horarioActual.getHoraInicio() == horarioDisponible.getHoraInicio() && horarioActual.getHoraFin() == horarioDisponible.getHoraFin()) {
                    throw new IllegalArgumentException("El horario ya está registrado en la " + this.nombre);
                }
            }
        }
    }

    // Getters y Setters
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
    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Set<Servicio> getServicios() { return servicios; }
    public void setServicios(Set<Servicio> servicios) { this.servicios = servicios; }

    public List<HorarioDisponible> getHorarioDisponibleList() {
        return horarioDisponibleList;
    }

    public void setHorarioDisponibleList(List<HorarioDisponible> horarioDisponibleList) {
        this.horarioDisponibleList = horarioDisponibleList;
    }

    public Set<TipoReserva> getTipoReservas() {
        return tipoReservas;
    }

    public void setTipoReservas(Set<TipoReserva> tipoReservas) {
        this.tipoReservas = tipoReservas;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }
}