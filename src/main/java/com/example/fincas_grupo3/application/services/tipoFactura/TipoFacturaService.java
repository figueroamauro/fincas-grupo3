package com.example.fincas_grupo3.application.services.tipoFactura;

import com.example.fincas_grupo3.application.dto.tipoFactura.TipoFacturaRequestDTO;
import com.example.fincas_grupo3.application.dto.tipoFactura.TipoFacturaResponseDTO;

import java.util.List;

public interface TipoFacturaService {
    TipoFacturaResponseDTO crearTipoFactura(TipoFacturaRequestDTO requestDTO);
    List<TipoFacturaResponseDTO> obtenerTodos();
    TipoFacturaResponseDTO obtenerPorId(Long id);
    TipoFacturaResponseDTO actualizarTipoFactura(TipoFacturaRequestDTO requestDTO);
    void eliminarTipoFactura(Long id);
}