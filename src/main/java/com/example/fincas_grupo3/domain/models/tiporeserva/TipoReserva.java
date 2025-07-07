package com.example.fincas_grupo3.domain.models.tiporeserva;

public class TipoReserva {
    private Long id;
    private String nombre;

    public TipoReserva(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoReserva() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}