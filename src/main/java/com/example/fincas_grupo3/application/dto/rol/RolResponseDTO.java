package com.example.fincas_grupo3.application.dto.rol;

public class RolResponseDTO {
    private String nombre;
    private Long id;
    public RolResponseDTO(String nombre, Long id) {
        this.nombre = nombre;
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
