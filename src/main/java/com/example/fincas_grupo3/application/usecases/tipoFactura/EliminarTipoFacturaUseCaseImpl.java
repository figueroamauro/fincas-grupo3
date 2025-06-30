package com.example.fincas_grupo3.application.usecases.tipoFactura;

import com.example.fincas_grupo3.domain.ports.in.tipoFactura.EliminarTipoFacturaUseCase;
import com.example.fincas_grupo3.domain.ports.out.tipoFactura.TipoFacturaOutPort;
import org.springframework.stereotype.Component;

@Component
public class EliminarTipoFacturaUseCaseImpl implements EliminarTipoFacturaUseCase {
    private final TipoFacturaOutPort tipoFacturaOutPort;

    public EliminarTipoFacturaUseCaseImpl(TipoFacturaOutPort tipoFacturaOutPort) {
        this.tipoFacturaOutPort = tipoFacturaOutPort;
    }

    @Override
    public boolean eliminarTipoFacturaPorId(Long id) {
        return tipoFacturaOutPort.deleteById(id);
    }
}