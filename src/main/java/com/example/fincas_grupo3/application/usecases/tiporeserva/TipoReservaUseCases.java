package com.example.fincas_grupo3.application.usecases.tiporeserva;

import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;
import com.example.fincas_grupo3.domain.ports.in.tiporeserva.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoReservaUseCases implements TipoReservaInPort {

    private final CrearTipoReservaUseCase crearTipoReservaUseCase;
    private final ObtenerTipoReservaUseCase obtenerTipoReservaUseCase;
    private final ActualizarTipoReservaUseCase actualizarTipoReservaUseCase;
    private final EliminarTipoReservaUseCase eliminarTipoReservaUseCase;

    public TipoReservaUseCases(CrearTipoReservaUseCase crearTipoReservaUseCase, ObtenerTipoReservaUseCase obtenerTipoReservaUseCase, ActualizarTipoReservaUseCase actualizarTipoReservaUseCase, EliminarTipoReservaUseCase eliminarTipoReservaUseCase) {
        this.crearTipoReservaUseCase = crearTipoReservaUseCase;
        this.obtenerTipoReservaUseCase = obtenerTipoReservaUseCase;
        this.actualizarTipoReservaUseCase = actualizarTipoReservaUseCase;
        this.eliminarTipoReservaUseCase = eliminarTipoReservaUseCase;
    }

    @Override
    public TipoReserva crearTipoReserva(TipoReserva tipoReserva) {
        return crearTipoReservaUseCase.crearTipoReserva(tipoReserva);
    }

    @Override
    public TipoReserva obtenerTipoReservaPorId(Long id) {
        return obtenerTipoReservaUseCase.obtenerTipoReservaPorId(id);
    }

    @Override
    public List<TipoReserva> obtenerTodosLosTiposReserva() {
        return obtenerTipoReservaUseCase.obtenerTodosLosTiposReserva();
    }

    @Override
    public TipoReserva actualizarTipoReserva(TipoReserva tipoReserva) {
        return actualizarTipoReservaUseCase.actualizarTipoReserva(tipoReserva);
    }

    @Override
    public boolean eliminarTipoReservaPorId(Long id) {
        return eliminarTipoReservaUseCase.eliminarTipoReservaPorId(id);
    }
}