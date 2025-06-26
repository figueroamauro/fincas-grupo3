package com.example.fincas_grupo3.application.usecases.tiporeserva;

import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;
import com.example.fincas_grupo3.domain.ports.in.tiporeserva.ObtenerTipoReservaUseCase;
import com.example.fincas_grupo3.domain.ports.out.tiporeserva.TipoReservaOutPort;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ObtenerTipoReservaUseCaseImpl implements ObtenerTipoReservaUseCase {
    private final TipoReservaOutPort tipoReservaOutPort;

    public ObtenerTipoReservaUseCaseImpl(TipoReservaOutPort tipoReservaOutPort) {
        this.tipoReservaOutPort = tipoReservaOutPort;
    }

    @Override
    public TipoReserva obtenerTipoReservaPorId(Long id) {
        return tipoReservaOutPort.findById(id);
    }

    @Override
    public List<TipoReserva> obtenerTodosLosTiposReserva() {
        return tipoReservaOutPort.findAll();
    }
}