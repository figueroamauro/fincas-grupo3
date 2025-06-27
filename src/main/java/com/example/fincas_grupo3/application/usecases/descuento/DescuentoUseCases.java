package com.example.fincas_grupo3.application.usecases.descuento;

import com.example.fincas_grupo3.domain.models.descuento.Descuento;
import com.example.fincas_grupo3.domain.ports.in.descuento.DescuentoInPort;
import com.example.fincas_grupo3.domain.ports.in.descuento.ActualizarDescuentoUseCase;
import com.example.fincas_grupo3.domain.ports.in.descuento.CrearDescuentoUseCase;
import com.example.fincas_grupo3.domain.ports.in.descuento.EliminarDescuentoUseCase;
import com.example.fincas_grupo3.domain.ports.in.descuento.ObtenerDescuentoUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescuentoUseCases implements DescuentoInPort {
    private final CrearDescuentoUseCase crearDescuentoUseCase;
    private final ActualizarDescuentoUseCase actualizarDescuentoUseCase;
    private final EliminarDescuentoUseCase eliminarDescuentoUseCase;
    private final ObtenerDescuentoUseCase obtenerDescuentoUseCase;

    public DescuentoUseCases(CrearDescuentoUseCase crearDescuentoUseCase, ActualizarDescuentoUseCase actualizarDescuentoUseCase, EliminarDescuentoUseCase eliminarDescuentoUseCase, ObtenerDescuentoUseCase obtenerDescuentoUseCase) {
        this.crearDescuentoUseCase = crearDescuentoUseCase;
        this.actualizarDescuentoUseCase = actualizarDescuentoUseCase;
        this.eliminarDescuentoUseCase = eliminarDescuentoUseCase;
        this.obtenerDescuentoUseCase = obtenerDescuentoUseCase;
    }


    @Override
    public Descuento actualizarDescuento(Descuento descuento) {
        return actualizarDescuentoUseCase.actualizarDescuento(descuento);
    }

    @Override
    public Descuento crearDescuento(Descuento descuento) {
        return crearDescuentoUseCase.crearDescuento(descuento);
    }

    @Override
    public Boolean eliminarDescuentoPorId(Long id) {
        return eliminarDescuentoUseCase.eliminarDescuentoPorId(id);
    }

    @Override
    public List<Descuento> obtenerDescuentos() {
        return obtenerDescuentoUseCase.obtenerDescuentos();
    }

    @Override
    public Descuento obtenerDescuentoPorId(Long id) {
        return obtenerDescuentoUseCase.obtenerDescuentoPorId(id);
    }
}
