package com.example.fincas_grupo3.application.services.finca;

import com.example.fincas_grupo3.application.dto.finca.FincaRequestDTO;
import com.example.fincas_grupo3.application.dto.finca.FincaResponseDTO;
import com.example.fincas_grupo3.domain.models.finca.Finca;

import java.util.List;

public interface FincaService {
    FincaResponseDTO guardar(FincaRequestDTO dto);

    FincaResponseDTO actualizar(FincaRequestDTO dto);

    List<FincaResponseDTO> obetenerTodas();

    FincaResponseDTO obtenerPorId(Long id);

    Boolean eliminarPorId(Long id);
}
