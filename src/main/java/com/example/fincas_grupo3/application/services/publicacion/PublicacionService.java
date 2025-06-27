package com.example.fincas_grupo3.application.services.publicacion;

import com.example.fincas_grupo3.application.dto.publicacion.PublicacionRequestDTO;
import com.example.fincas_grupo3.application.dto.publicacion.PublicacionResponseDTO;

import java.util.List;

public interface PublicacionService {
    PublicacionResponseDTO guardar(PublicacionRequestDTO dto);

    PublicacionResponseDTO actualizar(PublicacionRequestDTO dto);

    List<PublicacionResponseDTO> obtenerTodas();

    PublicacionResponseDTO obtenerPorId(Long id);

    Boolean eliminarPorId(Long id);
}
