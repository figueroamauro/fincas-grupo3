package com.example.fincas_grupo3.infrastructure.entities.foto;

import jakarta.persistence.*;

@Entity
@Table(name = "fotos")
public class FotoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url", nullable = false)
    private String url;

    public FotoEntidad() {
    }

    public FotoEntidad(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
