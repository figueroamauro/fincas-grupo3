package com.example.fincas_grupo3.application.services.horario;

import com.example.fincas_grupo3.application.dto.horario.HorarioDisponibleRequestDTO;
import com.example.fincas_grupo3.application.dto.horario.HorarioDisponibleResponseDTO;

import java.util.List;

public interface HorarioDisponibleService {
    HorarioDisponibleResponseDTO guardar(HorarioDisponibleRequestDTO dto);

    List<HorarioDisponibleResponseDTO> obtenerTodos();

    HorarioDisponibleResponseDTO obtenerPorId(Long id);

    Boolean eliminarPorId(Long id);
}
