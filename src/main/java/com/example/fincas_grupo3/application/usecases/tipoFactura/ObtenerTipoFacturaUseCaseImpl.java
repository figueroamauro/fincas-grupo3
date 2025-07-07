package com.example.fincas_grupo3.application.usecases.tipoFactura;

import com.example.fincas_grupo3.domain.models.tipoFactura.TipoFactura;
import com.example.fincas_grupo3.domain.ports.in.tipoFactura.ObtenerTipoFacturaUseCase;
import com.example.fincas_grupo3.domain.ports.out.tipoFactura.TipoFacturaOutPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObtenerTipoFacturaUseCaseImpl implements ObtenerTipoFacturaUseCase {
    private final TipoFacturaOutPort tipoFacturaOutPort;

    public ObtenerTipoFacturaUseCaseImpl(TipoFacturaOutPort tipoFacturaOutPort) {
        this.tipoFacturaOutPort = tipoFacturaOutPort;
    }

    @Override
    public TipoFactura obtenerTipoFacturaPorId(Long id) {
        return tipoFacturaOutPort.findById(id);
    }

    @Override
    public List<TipoFactura> obtenerTodosLosTiposFactura() {
        return tipoFacturaOutPort.findAll();
    }
}