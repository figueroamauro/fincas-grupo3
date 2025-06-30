package com.example.fincas_grupo3.application.usecases.tipoFactura;

import com.example.fincas_grupo3.domain.models.tipoFactura.TipoFactura;
import com.example.fincas_grupo3.domain.ports.in.tipoFactura.ActualizarTipoFacturaUseCase;
import com.example.fincas_grupo3.domain.ports.out.tipoFactura.TipoFacturaOutPort;
import org.springframework.stereotype.Component;

@Component
public class ActualizarTipoFacturaUseCaseImpl implements ActualizarTipoFacturaUseCase  {
    private final TipoFacturaOutPort tipoFacturaOutPort;

    public ActualizarTipoFacturaUseCaseImpl(TipoFacturaOutPort tipoFacturaOutPort) {
        this.tipoFacturaOutPort = tipoFacturaOutPort;
    }

    @Override
    public TipoFactura actualizarTipoFactura(TipoFactura tipoFactura) {
        return tipoFacturaOutPort.update(tipoFactura);
    }
}