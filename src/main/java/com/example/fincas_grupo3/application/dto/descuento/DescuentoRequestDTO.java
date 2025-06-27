package com.example.fincas_grupo3.application.dto.descuento;

public class DescuentoRequestDTO {
    private Long id;
    private int cantDias;
    private double porcentaje;

    public DescuentoRequestDTO(Long id, int cantDias, double porcentaje) {
        this.id = id;
        this.cantDias = cantDias;
        this.porcentaje = porcentaje;
    }
    public DescuentoRequestDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
       this.id = id;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

}
