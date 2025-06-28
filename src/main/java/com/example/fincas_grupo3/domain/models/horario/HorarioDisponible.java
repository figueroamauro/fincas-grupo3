package com.example.fincas_grupo3.domain.models.horario;

import com.example.fincas_grupo3.domain.enums.DiaSemana;
import com.example.fincas_grupo3.domain.exceptions.HorarioCruzadoException;

import java.time.LocalTime;

public class HorarioDisponible {
    private Long id;
    private DiaSemana diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public HorarioDisponible(Long id, DiaSemana diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        validarHorarios(horaInicio, horaFin);
        this.id = id;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public boolean seSolapaCon(HorarioDisponible otroHorario) {
        if (!this.diaSemana.equals(otroHorario.diaSemana)) return false;
        return !this.horaFin.isBefore(otroHorario.horaInicio) && !this.horaInicio.isAfter(otroHorario.horaFin);
    }


    private void validarHorarios(LocalTime horaInicio, LocalTime horaFin) {
        validarHorarioCruzado(horaInicio, horaFin);
    }

    private void validarHorarioCruzado(LocalTime horaInicio, LocalTime horaFin) {
        if (horaInicio.equals(horaFin) || horaInicio.isAfter(horaFin)) {
            throw new HorarioCruzadoException("El horario de inicio no puede ser mayor o igual al horario de fin");
        }
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
}
