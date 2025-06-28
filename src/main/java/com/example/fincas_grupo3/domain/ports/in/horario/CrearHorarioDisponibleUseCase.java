package com.example.fincas_grupo3.domain.ports.in.horario;

import com.example.fincas_grupo3.domain.models.horario.HorarioDisponible;

public interface CrearHorarioDisponibleUseCase {
    HorarioDisponible crearHorarioDisponible(HorarioDisponible horarioDisponible);
}
