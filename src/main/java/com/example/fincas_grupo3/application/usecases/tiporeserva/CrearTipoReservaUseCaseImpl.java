package com.example.fincas_grupo3.application.usecases.tiporeserva;

import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;
import com.example.fincas_grupo3.domain.ports.in.tiporeserva.CrearTipoReservaUseCase;
import com.example.fincas_grupo3.domain.ports.out.tiporeserva.TipoReservaOutPort;
import org.springframework.stereotype.Component;

@Component
public class CrearTipoReservaUseCaseImpl implements CrearTipoReservaUseCase {
    private final TipoReservaOutPort tipoReservaOutPort;

    public CrearTipoReservaUseCaseImpl(TipoReservaOutPort tipoReservaOutPort) {
        this.tipoReservaOutPort = tipoReservaOutPort;
    }

    @Override
    public TipoReserva crearTipoReserva(TipoReserva tipoReserva) {
        return tipoReservaOutPort.save(tipoReserva);
    }
}