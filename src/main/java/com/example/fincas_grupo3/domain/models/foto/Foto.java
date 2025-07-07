package com.example.fincas_grupo3.domain.models.foto;

import com.example.fincas_grupo3.domain.models.finca.Finca;

public class Foto {
    private Long id;
    private String url;
    private Finca finca;

    public Foto(Long id, String url) {
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

    public Finca getFinca() {
        return finca;
    }

    public void setFinca(Finca finca) {
        this.finca = finca;
    }
}
