package com.example.fincas_grupo3.application.usecases.estadoPago;

import com.example.fincas_grupo3.domain.models.estadoPago.EstadoPago;
import com.example.fincas_grupo3.domain.ports.in.estadoPago.ActualizarEstadoPagoUseCase;
import com.example.fincas_grupo3.domain.ports.out.estadoPago.EstadoPagoOutPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarEstadoPagoUseCaseImpl implements ActualizarEstadoPagoUseCase {
    private final EstadoPagoOutPort estadoPagoOutPort;

    public ActualizarEstadoPagoUseCaseImpl(EstadoPagoOutPort estadoPagoOutPort) {
        this.estadoPagoOutPort = estadoPagoOutPort;
    }

    @Override
    public EstadoPago actualizarEstadoPago(EstadoPago estadoPago) {
        return estadoPagoOutPort.update(estadoPago);
    }
}