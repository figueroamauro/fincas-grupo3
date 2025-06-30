package com.example.fincas_grupo3.application.usecases.tipoFactura;

import com.example.fincas_grupo3.domain.models.tipoFactura.TipoFactura;
import com.example.fincas_grupo3.domain.ports.in.tipoFactura.CrearTipoFacturaUseCase;
import com.example.fincas_grupo3.domain.ports.out.tipoFactura.TipoFacturaOutPort;
import org.springframework.stereotype.Component;

@Component
public class CrearTipoFacturaUseCaseImpl implements CrearTipoFacturaUseCase {
    private final TipoFacturaOutPort tipoFacturaOutPort;

    public CrearTipoFacturaUseCaseImpl(TipoFacturaOutPort tipoFacturaOutPort) {
        this.tipoFacturaOutPort = tipoFacturaOutPort;
    }

    @Override
    public TipoFactura crearTipoFactura(TipoFactura tipoFactura) {
        return tipoFacturaOutPort.save(tipoFactura);
    }
}