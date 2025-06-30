package com.example.fincas_grupo3.application.usecases.estadoPago;

import com.example.fincas_grupo3.domain.models.estadoPago.EstadoPago;
import com.example.fincas_grupo3.domain.ports.in.estadoPago.ObtenerEstadoPagoUseCase;
import com.example.fincas_grupo3.domain.ports.out.estadoPago.EstadoPagoOutPort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ObtenerEstadoPagoUseCaseImpl implements ObtenerEstadoPagoUseCase {
    private final EstadoPagoOutPort estadoReservaOutPort;

    public ObtenerEstadoPagoUseCaseImpl(EstadoPagoOutPort estadoReservaOutPort) {
        this.estadoReservaOutPort = estadoReservaOutPort;
    }

    @Override
    public EstadoPago obtenerEstadoPagoPorId(Long id) {
        return estadoReservaOutPort.findById(id);
    }

    @Override
    public List<EstadoPago> obtenerTodosLosEstadosReserva() {
        return estadoReservaOutPort.findAll();
    }
}