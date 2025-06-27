package com.example.fincas_grupo3.application.services.pago;

import com.example.fincas_grupo3.application.dto.pago.PagoRequestDTO;
import com.example.fincas_grupo3.application.dto.pago.PagoResponseDTO;
import java.util.List;

public interface PagoService {
    PagoResponseDTO crearPago(PagoRequestDTO requestDTO);
    List<PagoResponseDTO> obtenerTodos();
    PagoResponseDTO obtenerPorId(Long id);
    PagoResponseDTO actualizarPago(PagoRequestDTO requestDTO);
    void eliminarPago(Long id);
}