package com.example.fincas_grupo3.application.services.direccion;

import com.example.fincas_grupo3.application.dto.direccion.DireccionRequestDTO;
import com.example.fincas_grupo3.application.dto.direccion.DireccionResponseDTO;
import com.example.fincas_grupo3.application.dto.finca.FincaRequestDTO;
import com.example.fincas_grupo3.application.dto.finca.FincaResponseDTO;

import java.util.List;

public interface DireccionService {

    DireccionResponseDTO guardar(DireccionRequestDTO dto);

    DireccionResponseDTO actualizar(DireccionRequestDTO dto);

    List<DireccionResponseDTO> obtenerTodas();

    DireccionResponseDTO obtenerPorId(Long id);

    Boolean eliminarPorId(Long id);


}
