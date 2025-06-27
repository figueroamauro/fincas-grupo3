package com.example.fincas_grupo3.application.services.descuento;



import com.example.fincas_grupo3.application.dto.descuento.DescuentoRequestDTO;
import com.example.fincas_grupo3.application.dto.descuento.DescuentoResponseDTO;


import java.util.List;


public interface DescuentoService {
    DescuentoResponseDTO guardar(DescuentoRequestDTO dto);

    DescuentoResponseDTO actualizar(DescuentoRequestDTO dto);

    List<DescuentoResponseDTO> obtenerTodas();

    DescuentoResponseDTO obtenerPorId(Long id);

    Boolean eliminarPorId(Long id);

}
