package com.example.fincas_grupo3.application.dto.direccion;

public class DireccionRequestDTO {

    private Long id;
    private String calle;
    private String numero;
    private String codigoPostal;
    private Long ciudadId;

    public DireccionRequestDTO(Long id, String calle, String numero, String codigoPostal, Long ciudadId) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudadId = ciudadId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Long getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Long ciudadId) {
        this.ciudadId = ciudadId;
    }
}
