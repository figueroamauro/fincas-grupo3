package com.example.fincas_grupo3.application.services.estadoPago;

import com.example.fincas_grupo3.application.dto.estadoPago.EstadoPagoRequestDTO;
import com.example.fincas_grupo3.application.dto.estadoPago.EstadoPagoResponseDTO;

import java.util.List;

public interface EstadoPagoService {
    EstadoPagoResponseDTO crearEstadoPago(EstadoPagoRequestDTO requestDTO);
    List<EstadoPagoResponseDTO> obtenerTodos();
    EstadoPagoResponseDTO obtenerPorId(Long id);
    EstadoPagoResponseDTO actualizarEstadoPago(EstadoPagoRequestDTO requestDTO);
    void eliminarEstadoPago(Long id);
}
