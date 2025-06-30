package com.example.fincas_grupo3.domain.ports.in.estadoPago;

import com.example.fincas_grupo3.domain.models.estadoPago.EstadoPago;


import java.util.List;

public interface ObtenerEstadoPagoUseCase {
    EstadoPago obtenerEstadoPagoPorId(Long id);
    List<EstadoPago> obtenerTodosLosEstadosReserva();
}
