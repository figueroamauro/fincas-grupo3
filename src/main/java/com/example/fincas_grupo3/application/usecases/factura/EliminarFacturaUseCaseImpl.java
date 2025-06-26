package com.example.fincas_grupo3.application.usecases.factura;

import com.example.fincas_grupo3.domain.ports.in.factura.EliminarFacturaUseCase;
import com.example.fincas_grupo3.domain.ports.out.factura.FacturaOutPort;
import org.springframework.stereotype.Component;

@Component
public class EliminarFacturaUseCaseImpl implements EliminarFacturaUseCase {
    private final FacturaOutPort facturaOutPort;

    public EliminarFacturaUseCaseImpl(FacturaOutPort facturaOutPort) {
        this.facturaOutPort = facturaOutPort;
    }

    @Override
    public boolean eliminarFacturaPorId(Long id) {
        return facturaOutPort.deleteById(id);
    }
}