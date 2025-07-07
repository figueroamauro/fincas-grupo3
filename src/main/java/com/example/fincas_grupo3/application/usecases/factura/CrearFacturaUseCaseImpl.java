package com.example.fincas_grupo3.application.usecases.factura;

import com.example.fincas_grupo3.domain.models.factura.Factura;
import com.example.fincas_grupo3.domain.ports.in.factura.CrearFacturaUseCase;
import com.example.fincas_grupo3.domain.ports.out.factura.FacturaOutPort;
import org.springframework.stereotype.Component;

@Component
public class CrearFacturaUseCaseImpl implements CrearFacturaUseCase {
    private final FacturaOutPort facturaOutPort;

    public CrearFacturaUseCaseImpl(FacturaOutPort facturaOutPort) {
        this.facturaOutPort = facturaOutPort;
    }

    @Override
    public Factura crearFactura(Factura factura) {
        return facturaOutPort.save(factura);
    }
}