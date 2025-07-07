package com.example.fincas_grupo3.domain.ports.in.estadoPago;

import com.example.fincas_grupo3.domain.ports.in.estadoPago.ActualizarEstadoPagoUseCase;
import com.example.fincas_grupo3.domain.ports.in.estadoPago.CrearEstadoPagoUseCase;
import com.example.fincas_grupo3.domain.ports.in.estadoPago.EliminarEstadoPagoUseCase;
import com.example.fincas_grupo3.domain.ports.in.estadoPago.ObtenerEstadoPagoUseCase;

public interface EstadoPagoInPort extends CrearEstadoPagoUseCase, ObtenerEstadoPagoUseCase, ActualizarEstadoPagoUseCase, EliminarEstadoPagoUseCase {
}
