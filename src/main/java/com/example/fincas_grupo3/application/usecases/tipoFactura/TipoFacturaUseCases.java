package com.example.fincas_grupo3.application.usecases.tipoFactura;

import com.example.fincas_grupo3.domain.models.tipoFactura.TipoFactura;
import com.example.fincas_grupo3.domain.ports.in.tipoFactura.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoFacturaUseCases implements TipoFacturaInPort {

    private final CrearTipoFacturaUseCase crearTipoFacturaUseCase;
    private final ObtenerTipoFacturaUseCase obtenerTipoFacturaUseCase;
    private final ActualizarTipoFacturaUseCase actualizarTipoFacturaUseCase;
    private final EliminarTipoFacturaUseCase eliminarTipoFacturaUseCase;

    public TipoFacturaUseCases(CrearTipoFacturaUseCase crearTipoFacturaUseCase, ObtenerTipoFacturaUseCase obtenerTipoFacturaUseCase, ActualizarTipoFacturaUseCase actualizarTipoFacturaUseCase, EliminarTipoFacturaUseCase eliminarTipoFacturaUseCase) {
        this.crearTipoFacturaUseCase = crearTipoFacturaUseCase;
        this.obtenerTipoFacturaUseCase = obtenerTipoFacturaUseCase;
        this.actualizarTipoFacturaUseCase = actualizarTipoFacturaUseCase;
        this.eliminarTipoFacturaUseCase = eliminarTipoFacturaUseCase;
    }

    @Override
    public TipoFactura crearTipoFactura(TipoFactura tipoFactura) {
        return crearTipoFacturaUseCase.crearTipoFactura(tipoFactura);
    }

    @Override
    public TipoFactura obtenerTipoFacturaPorId(Long id) {
        return obtenerTipoFacturaUseCase.obtenerTipoFacturaPorId(id);
    }

    @Override
    public List<TipoFactura> obtenerTodosLosTiposFactura() {
        return obtenerTipoFacturaUseCase.obtenerTodosLosTiposFactura();
    }

    @Override
    public TipoFactura actualizarTipoFactura(TipoFactura tipoFactura) {
        return actualizarTipoFacturaUseCase.actualizarTipoFactura(tipoFactura);
    }

    @Override
    public boolean eliminarTipoFacturaPorId(Long id) {
        return eliminarTipoFacturaUseCase.eliminarTipoFacturaPorId(id);
    }
}