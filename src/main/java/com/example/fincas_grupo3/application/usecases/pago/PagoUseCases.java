package com.example.fincas_grupo3.application.usecases.pago;

import com.example.fincas_grupo3.domain.models.pago.Pago;
import com.example.fincas_grupo3.domain.ports.in.pago.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PagoUseCases implements PagoInPort {

    private final CrearPagoUseCase crearPagoUseCase;
    private final ObtenerPagoUseCase obtenerPagoUseCase;
    private final ActualizarPagoUseCase actualizarPagoUseCase;
    private final EliminarPagoUseCase eliminarPagoUseCase;

    public PagoUseCases(CrearPagoUseCase crearPagoUseCase, ObtenerPagoUseCase obtenerPagoUseCase, ActualizarPagoUseCase actualizarPagoUseCase, EliminarPagoUseCase eliminarPagoUseCase) {
        this.crearPagoUseCase = crearPagoUseCase;
        this.obtenerPagoUseCase = obtenerPagoUseCase;
        this.actualizarPagoUseCase = actualizarPagoUseCase;
        this.eliminarPagoUseCase = eliminarPagoUseCase;
    }

    @Override
    public Pago crearPago(Pago pago) {
        return crearPagoUseCase.crearPago(pago);
    }

    @Override
    public Pago obtenerPagoPorId(Long id) {
        return obtenerPagoUseCase.obtenerPagoPorId(id);
    }

    @Override
    public List<Pago> obtenerTodosLosPagos() {
        return obtenerPagoUseCase.obtenerTodosLosPagos();
    }

    @Override
    public Pago actualizarPago(Pago pago) {
        return actualizarPagoUseCase.actualizarPago(pago);
    }

    @Override
    public boolean eliminarPagoPorId(Long id) {
        return eliminarPagoUseCase.eliminarPagoPorId(id);
    }
}