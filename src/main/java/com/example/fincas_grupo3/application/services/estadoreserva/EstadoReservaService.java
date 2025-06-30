package com.example.fincas_grupo3.application.services.estadoreserva;

import com.example.fincas_grupo3.application.dto.estadoreserva.EstadoReservaRequestDTO;
import com.example.fincas_grupo3.application.dto.estadoreserva.EstadoReservaResponseDTO;
import java.util.List;

public interface EstadoReservaService {
    EstadoReservaResponseDTO crearEstadoReserva(EstadoReservaRequestDTO requestDTO);
    List<EstadoReservaResponseDTO> obtenerTodos();
    EstadoReservaResponseDTO obtenerPorId(Long id);
    EstadoReservaResponseDTO actualizarEstadoReserva(EstadoReservaRequestDTO requestDTO);
    void eliminarEstadoReserva(Long id);
}