package com.example.fincas_grupo3.application.services.reserva;


import com.example.fincas_grupo3.application.dto.reserva.ReservaRequestDTO;
import com.example.fincas_grupo3.application.dto.reserva.ReservaResponseDTO;

import java.util.List;

public interface ReservaService {

    ReservaResponseDTO guardar(ReservaRequestDTO dto);

    ReservaResponseDTO actualizar(ReservaRequestDTO dto);

    List<ReservaResponseDTO> obtenerTodas();

    ReservaResponseDTO obtenerPorId(Long id);

    Boolean eliminarPorId(Long id);
}
