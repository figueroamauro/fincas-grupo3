package com.example.fincas_grupo3.application.usecases.estadoPago;

import com.example.fincas_grupo3.domain.ports.in.estadoPago.EliminarEstadoPagoUseCase;
import com.example.fincas_grupo3.domain.ports.out.estadoPago.EstadoPagoOutPort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class EliminarEstadoPagoUseCaseImpl implements EliminarEstadoPagoUseCase {
    private final EstadoPagoOutPort estadoReservaOutPort;

    public EliminarEstadoPagoUseCaseImpl(EstadoPagoOutPort estadoReservaOutPort) {
        this.estadoReservaOutPort = estadoReservaOutPort;
    }

    @Override
    public boolean eliminarEstadoPagoPorId(Long id) {
        return estadoReservaOutPort.deleteById(id);
    }
}