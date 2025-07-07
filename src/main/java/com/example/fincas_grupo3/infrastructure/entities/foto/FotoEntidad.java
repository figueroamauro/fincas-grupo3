package com.example.fincas_grupo3.infrastructure.entities.foto;

import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.infrastructure.entities.finca.FincaEntidad;
import jakarta.persistence.*;

@Entity
@Table(name = "fotos")
public class FotoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url_imagen", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "finca_id")
    private FincaEntidad finca;

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

    public FincaEntidad getFinca() {
        return finca;
    }

    public void setFinca(FincaEntidad finca) {
        this.finca = finca;
    }
}
