package com.example.fincas_grupo3.application.services.provincia;

import com.example.fincas_grupo3.application.dto.provincia.ProvinciaRequestDTO;
import com.example.fincas_grupo3.application.dto.provincia.ProvinciaResponseDTO;

import java.util.List;

public interface ProvinciaService {
    ProvinciaResponseDTO guardar(ProvinciaRequestDTO dto);

    ProvinciaResponseDTO actualizar(ProvinciaRequestDTO dto);

    List<ProvinciaResponseDTO> obtenerTodas();

    ProvinciaResponseDTO obtenerPorId(Long id);

    Boolean eliminarPorId(Long id);
}