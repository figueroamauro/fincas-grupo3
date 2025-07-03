package com.example.fincas_grupo3.domain.models.finca;

import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import com.example.fincas_grupo3.domain.models.servicio.Servicio;
import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import java.util.List;

public class Finca {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double tarifaHora;
    private Double tarifaDia;
    private Direccion direccion;
    private Usuario usuario;
    private List<Servicio> servicios;

    public Finca(Long id, String nombre, String descripcion, Double tarifaHora, Double tarifaDia, Direccion direccion, Usuario usuario, List<Servicio> servicios) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tarifaHora = tarifaHora;
        this.tarifaDia = tarifaDia;
        this.direccion = direccion;
        this.usuario = usuario;
        this.servicios = servicios;
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
    public List<Servicio> getServicios() { return servicios; }
    public void setServicios(List<Servicio> servicios) { this.servicios = servicios; }
}