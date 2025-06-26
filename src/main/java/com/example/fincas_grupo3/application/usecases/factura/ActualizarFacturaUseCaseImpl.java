package com.example.fincas_grupo3.application.usecases.factura;

import com.example.fincas_grupo3.domain.models.factura.Factura;
import com.example.fincas_grupo3.domain.ports.in.factura.ActualizarFacturaUseCase;
import com.example.fincas_grupo3.domain.ports.out.factura.FacturaOutPort;
import org.springframework.stereotype.Component;

@Component
public class ActualizarFacturaUseCaseImpl implements ActualizarFacturaUseCase {
    private final FacturaOutPort facturaOutPort;

    public ActualizarFacturaUseCaseImpl(FacturaOutPort facturaOutPort) {
        this.facturaOutPort = facturaOutPort;
    }

    @Override
    public Factura actualizarFactura(Factura factura) {
        return facturaOutPort.update(factura);
    }
}