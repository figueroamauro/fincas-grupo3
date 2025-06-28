package com.example.fincas_grupo3.domain.ports.out.horario;

import com.example.fincas_grupo3.domain.models.horario.HorarioDisponible;

import java.util.List;

public interface HorarioDisponibleOutPort {
    HorarioDisponible guardar(HorarioDisponible horarioDisponible);

    List<HorarioDisponible> obtenerTodos();

    HorarioDisponible obtenerPorId(Long id);

    Boolean eliminarPorId(Long id);
}
