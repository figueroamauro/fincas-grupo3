package com.example.fincas_grupo3.application.dto.rol;

public class RolResponseDTO {
    private Long id;
    private String nombre;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
