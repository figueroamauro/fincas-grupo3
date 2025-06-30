package com.example.fincas_grupo3.domain.ports.in.horario;

import com.example.fincas_grupo3.domain.models.horario.HorarioDisponible;

import java.util.List;

public interface ObtenerHorarioDisponibleUseCase {
    List<HorarioDisponible> obtenerHorariosDisponibles();

    HorarioDisponible obtenerHorarioDisponiblePorId(Long id);
}
