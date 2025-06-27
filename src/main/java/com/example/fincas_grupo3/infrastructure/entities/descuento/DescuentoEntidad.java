package com.example.fincas_grupo3.infrastructure.entities.descuento;


import jakarta.persistence.*;

@Entity
@Table(name="descuentos")
public class DescuentoEntidad {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "cant_dias", nullable = false)
    private int cantDias;

    @Column (name = "porcentaje", nullable = false)
    private double  porcentaje;

    public DescuentoEntidad() {}

    public DescuentoEntidad(Long id, int cantDias, double porcentaje) {
        this.id = id;
        this.cantDias = cantDias;

        this.porcentaje = porcentaje;

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
