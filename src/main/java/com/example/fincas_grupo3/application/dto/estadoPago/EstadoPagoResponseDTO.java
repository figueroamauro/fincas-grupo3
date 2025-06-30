package com.example.fincas_grupo3.application.dto.estadoPago;

public class EstadoPagoResponseDTO {
    private Long id;
    private String nombre;

    public EstadoPagoResponseDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
