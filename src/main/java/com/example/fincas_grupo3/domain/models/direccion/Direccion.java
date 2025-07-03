package com.example.fincas_grupo3.domain.models.direccion;

import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;

public class Direccion {

    private Long id;
    private String calle;
    private String numero;
    private String codigoPostal;
    private Ciudad ciudad;

    public Direccion() {
    }

    public Direccion(Long id, String calle, String numero, String codigoPostal, Ciudad ciudad) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}