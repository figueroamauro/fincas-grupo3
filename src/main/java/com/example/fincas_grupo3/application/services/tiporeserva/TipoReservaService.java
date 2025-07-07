package com.example.fincas_grupo3.application.services.tiporeserva;

import com.example.fincas_grupo3.application.dto.tiporeserva.TipoReservaRequestDTO;
import com.example.fincas_grupo3.application.dto.tiporeserva.TipoReservaResponseDTO;
import java.util.List;

public interface TipoReservaService {
    TipoReservaResponseDTO crearTipoReserva(TipoReservaRequestDTO requestDTO);
    List<TipoReservaResponseDTO> obtenerTodos();
    TipoReservaResponseDTO obtenerPorId(Long id);
    TipoReservaResponseDTO actualizarTipoReserva(TipoReservaRequestDTO requestDTO);
    void eliminarTipoReserva(Long id);
}