package com.example.fincas_grupo3.application.services.factura;

import com.example.fincas_grupo3.application.dto.factura.FacturaRequestDTO;
import com.example.fincas_grupo3.application.dto.factura.FacturaResponseDTO;
import java.util.List;

public interface FacturaService {
    FacturaResponseDTO crearFactura(FacturaRequestDTO requestDTO);
    List<FacturaResponseDTO> obtenerTodas();
    FacturaResponseDTO obtenerPorId(Long id);
    FacturaResponseDTO actualizarFactura(FacturaRequestDTO requestDTO);
    void eliminarFactura(Long id);
}