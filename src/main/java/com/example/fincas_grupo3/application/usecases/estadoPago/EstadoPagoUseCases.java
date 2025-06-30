package com.example.fincas_grupo3.application.usecases.estadoPago;

import com.example.fincas_grupo3.domain.models.estadoPago.EstadoPago;
import com.example.fincas_grupo3.domain.ports.in.estadoPago.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstadoPagoUseCases implements EstadoPagoInPort {

    private final CrearEstadoPagoUseCase crearEstadoPagoUseCase;
    private final ObtenerEstadoPagoUseCase obtenerEstadoPagoUseCase;
    private final ActualizarEstadoPagoUseCase actualizarEstadoPagoUseCase;
    private final EliminarEstadoPagoUseCase eliminarEstadoPagoUseCase;

    public EstadoPagoUseCases(CrearEstadoPagoUseCase crearEstadoPagoUseCase,
                                 ObtenerEstadoPagoUseCase obtenerEstadoPagoUseCase,
                                 ActualizarEstadoPagoUseCase actualizarEstadoPagoUseCase,
                                 EliminarEstadoPagoUseCase eliminarEstadoPagoUseCase) {
        this.crearEstadoPagoUseCase = crearEstadoPagoUseCase;
        this.obtenerEstadoPagoUseCase = obtenerEstadoPagoUseCase;
        this.actualizarEstadoPagoUseCase = actualizarEstadoPagoUseCase;
        this.eliminarEstadoPagoUseCase = eliminarEstadoPagoUseCase;
    }

    @Override
    public EstadoPago crearEstadoPago(EstadoPago estadoReserva) {
        return crearEstadoPagoUseCase.crearEstadoPago(estadoReserva);
    }

    @Override
    public EstadoPago obtenerEstadoPagoPorId(Long id) {
        return obtenerEstadoPagoUseCase.obtenerEstadoPagoPorId(id);
    }

    @Override
    public List<EstadoPago> obtenerTodosLosEstadosReserva() {
        return obtenerEstadoPagoUseCase.obtenerTodosLosEstadosReserva();
    }

    @Override
    public EstadoPago actualizarEstadoPago(EstadoPago estadoReserva) {
        return actualizarEstadoPagoUseCase.actualizarEstadoPago(estadoReserva);
    }

    @Override
    public boolean eliminarEstadoPagoPorId(Long id) {
        return eliminarEstadoPagoUseCase.eliminarEstadoPagoPorId(id);
    }
}