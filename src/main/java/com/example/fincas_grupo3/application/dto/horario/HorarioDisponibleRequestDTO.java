package com.example.fincas_grupo3.application.dto.horario;

import com.example.fincas_grupo3.domain.enums.DiaSemana;

import java.time.LocalTime;

public class HorarioDisponibleRequestDTO {
    private DiaSemana diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Long fincaId;

    public HorarioDisponibleRequestDTO(DiaSemana diaSemana, LocalTime horaInicio, LocalTime horaFin,Long fincaId) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fincaId = fincaId;
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

    public Long getFincaId() {
        return fincaId;
    }

    public void setFincaId(Long fincaId) {
        this.fincaId = fincaId;
    }
}
