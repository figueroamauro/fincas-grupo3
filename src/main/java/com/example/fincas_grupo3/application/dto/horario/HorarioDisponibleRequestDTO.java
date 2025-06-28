package com.example.fincas_grupo3.application.dto.horario;

import com.example.fincas_grupo3.domain.enums.DiaSemana;

import java.time.LocalTime;

public class HorarioDisponibleRequestDTO {
    private DiaSemana diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public HorarioDisponibleRequestDTO(DiaSemana diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
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
}
