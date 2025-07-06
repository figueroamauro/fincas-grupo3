package com.example.fincas_grupo3.infrastructure.entities.horario;

import com.example.fincas_grupo3.domain.enums.DiaSemana;
import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.infrastructure.entities.finca.FincaEntidad;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "horarios_disponibles")
public class HorarioDisponibleEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dia_semana", nullable = false)
    private DiaSemana diaSemana;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "finca_id")
    private FincaEntidad finca;

    public HorarioDisponibleEntidad() {
    }

    public HorarioDisponibleEntidad(Long id, DiaSemana diaSemana, LocalTime horaInicio, LocalTime horaFin,FincaEntidad finca) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.finca = finca;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public FincaEntidad getFinca() {
        return finca;
    }

    public void setFinca(FincaEntidad finca) {
        this.finca = finca;
    }
}
