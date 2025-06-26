package com.example.fincas_grupo3.application.services.foto;

import com.example.fincas_grupo3.application.dto.foto.FotoRequestDTO;
import com.example.fincas_grupo3.application.dto.foto.FotoResponseDTO;
import com.example.fincas_grupo3.domain.models.foto.Foto;

import java.util.List;

public interface FotoService {
    FotoResponseDTO guardar(FotoRequestDTO dto);

    FotoResponseDTO actualizar(FotoRequestDTO dto);

    List<FotoResponseDTO> obtenerTodas();

    FotoResponseDTO obtenerPorId(Long id);

    Boolean eliminarPorId(Long id);
}
