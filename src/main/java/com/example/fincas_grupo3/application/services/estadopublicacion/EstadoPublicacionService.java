package com.example.fincas_grupo3.application.services.estadopublicacion;

import com.example.fincas_grupo3.application.dto.estadopublicacion.EstadoPublicacionRequestDTO;
import com.example.fincas_grupo3.application.dto.estadopublicacion.EstadoPublicacionResponseDTO;


import java.util.List;

public interface EstadoPublicacionService {
    EstadoPublicacionResponseDTO guardar(EstadoPublicacionRequestDTO dto);

    EstadoPublicacionResponseDTO actualizar(EstadoPublicacionRequestDTO dto);

    List<EstadoPublicacionResponseDTO> obtenerTodas();

    EstadoPublicacionResponseDTO obtenerPorId(Long id);

    Boolean eliminarPorId(Long id);
}
