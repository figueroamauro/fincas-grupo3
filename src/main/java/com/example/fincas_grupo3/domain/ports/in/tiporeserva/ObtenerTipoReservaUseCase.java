package com.example.fincas_grupo3.domain.ports.in.tiporeserva;

import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;
import java.util.List;

public interface ObtenerTipoReservaUseCase {
    TipoReserva obtenerTipoReservaPorId(Long id);
    List<TipoReserva> obtenerTodosLosTiposReserva();
}