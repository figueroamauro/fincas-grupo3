package com.example.fincas_grupo3.application.dto.foto;

public class FotoRequestDTO {
    private Long id;
    private String url;

    public FotoRequestDTO(Long id, String url) {
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
