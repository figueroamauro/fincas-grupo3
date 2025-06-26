package com.example.fincas_grupo3.application.usecases.tiporeserva;

import com.example.fincas_grupo3.domain.ports.in.tiporeserva.EliminarTipoReservaUseCase;
import com.example.fincas_grupo3.domain.ports.out.tiporeserva.TipoReservaOutPort;
import org.springframework.stereotype.Component;

@Component
public class EliminarTipoReservaUseCaseImpl implements EliminarTipoReservaUseCase {
    private final TipoReservaOutPort tipoReservaOutPort;

    public EliminarTipoReservaUseCaseImpl(TipoReservaOutPort tipoReservaOutPort) {
        this.tipoReservaOutPort = tipoReservaOutPort;
    }

    @Override
    public boolean eliminarTipoReservaPorId(Long id) {
        return tipoReservaOutPort.deleteById(id);
    }
}