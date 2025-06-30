package com.example.fincas_grupo3.application.usecases.estadoPago;

import com.example.fincas_grupo3.domain.models.estadoPago.EstadoPago;
import com.example.fincas_grupo3.domain.ports.in.estadoPago.CrearEstadoPagoUseCase;
import com.example.fincas_grupo3.domain.ports.out.estadoPago.EstadoPagoOutPort;
import org.springframework.stereotype.Service;

@Service
public class CrearEstadoPagoUseCaseImpl implements CrearEstadoPagoUseCase {
    private final EstadoPagoOutPort estadoPagoOutPort;

    public CrearEstadoPagoUseCaseImpl(EstadoPagoOutPort estadoPagoOutPort) {
        this.estadoPagoOutPort = estadoPagoOutPort;
    }

    @Override
    public EstadoPago crearEstadoPago(EstadoPago estadoPago) {
        return estadoPagoOutPort.save(estadoPago);
    }
}
