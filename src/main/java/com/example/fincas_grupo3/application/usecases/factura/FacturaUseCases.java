package com.example.fincas_grupo3.application.usecases.factura;

import com.example.fincas_grupo3.domain.models.factura.Factura;
import com.example.fincas_grupo3.domain.ports.in.factura.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacturaUseCases implements FacturaInPort {

    private final CrearFacturaUseCase crearFacturaUseCase;
    private final ObtenerFacturaUseCase obtenerFacturaUseCase;
    private final ActualizarFacturaUseCase actualizarFacturaUseCase;
    private final EliminarFacturaUseCase eliminarFacturaUseCase;

    public FacturaUseCases(CrearFacturaUseCase crearFacturaUseCase, ObtenerFacturaUseCase obtenerFacturaUseCase, ActualizarFacturaUseCase actualizarFacturaUseCase, EliminarFacturaUseCase eliminarFacturaUseCase) {
        this.crearFacturaUseCase = crearFacturaUseCase;
        this.obtenerFacturaUseCase = obtenerFacturaUseCase;
        this.actualizarFacturaUseCase = actualizarFacturaUseCase;
        this.eliminarFacturaUseCase = eliminarFacturaUseCase;
    }

    @Override
    public Factura crearFactura(Factura factura) {
        return crearFacturaUseCase.crearFactura(factura);
    }

    @Override
    public Factura obtenerFacturaPorId(Long id) {
        return obtenerFacturaUseCase.obtenerFacturaPorId(id);
    }

    @Override
    public List<Factura> obtenerTodasLasFacturas() {
        return obtenerFacturaUseCase.obtenerTodasLasFacturas();
    }

    @Override
    public Factura actualizarFactura(Factura factura) {
        return actualizarFacturaUseCase.actualizarFactura(factura);
    }

    @Override
    public boolean eliminarFacturaPorId(Long id) {
        return eliminarFacturaUseCase.eliminarFacturaPorId(id);
    }
}