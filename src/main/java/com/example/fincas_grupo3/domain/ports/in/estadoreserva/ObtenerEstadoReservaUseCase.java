package com.example.fincas_grupo3.domain.ports.in.estadoreserva;

import com.example.fincas_grupo3.domain.models.estadoreserva.EstadoReserva;
import java.util.List;

public interface ObtenerEstadoReservaUseCase {
    EstadoReserva obtenerEstadoReservaPorId(Long id);
    List<EstadoReserva> obtenerTodosLosEstadosReserva();
}