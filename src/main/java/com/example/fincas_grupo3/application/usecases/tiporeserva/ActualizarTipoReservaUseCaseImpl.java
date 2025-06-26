package com.example.fincas_grupo3.application.usecases.tiporeserva;

import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;
import com.example.fincas_grupo3.domain.ports.in.tiporeserva.ActualizarTipoReservaUseCase;
import com.example.fincas_grupo3.domain.ports.out.tiporeserva.TipoReservaOutPort;
import org.springframework.stereotype.Component;

@Component
public class ActualizarTipoReservaUseCaseImpl implements ActualizarTipoReservaUseCase {
    private final TipoReservaOutPort tipoReservaOutPort;

    public ActualizarTipoReservaUseCaseImpl(TipoReservaOutPort tipoReservaOutPort) {
        this.tipoReservaOutPort = tipoReservaOutPort;
    }

    @Override
    public TipoReserva actualizarTipoReserva(TipoReserva tipoReserva) {
        return tipoReservaOutPort.update(tipoReserva);
    }
}