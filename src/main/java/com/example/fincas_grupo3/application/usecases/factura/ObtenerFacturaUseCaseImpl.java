package com.example.fincas_grupo3.application.usecases.factura;

import com.example.fincas_grupo3.domain.models.factura.Factura;
import com.example.fincas_grupo3.domain.ports.in.factura.ObtenerFacturaUseCase;
import com.example.fincas_grupo3.domain.ports.out.factura.FacturaOutPort;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ObtenerFacturaUseCaseImpl implements ObtenerFacturaUseCase {
    private final FacturaOutPort facturaOutPort;

    public ObtenerFacturaUseCaseImpl(FacturaOutPort facturaOutPort) {
        this.facturaOutPort = facturaOutPort;
    }

    @Override
    public Factura obtenerFacturaPorId(Long id) {
        return facturaOutPort.findById(id);
    }

    @Override
    public List<Factura> obtenerTodasLasFacturas() {
        return facturaOutPort.findAll();
    }
}