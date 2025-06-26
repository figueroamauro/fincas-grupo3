package com.example.fincas_grupo3.application.usecases.finca;

import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.domain.ports.in.finca.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FincaUseCases implements FincaInPort {
    private final CrearFincaUseCase crearFincaUseCase;
    private final ActualizarFincaUseCase actualizarFincaUseCase;
    private final EliminarFincaUseCase eliminarFincaUseCase;
    private final ObtenerFincaUseCase obtenerFincaUseCase;

    public FincaUseCases(CrearFincaUseCase crearFincaUseCase, ActualizarFincaUseCase actualizarFincaUseCase, EliminarFincaUseCase eliminarFincaUseCase, ObtenerFincaUseCase obtenerFincaUseCase) {
        this.crearFincaUseCase = crearFincaUseCase;
        this.actualizarFincaUseCase = actualizarFincaUseCase;
        this.eliminarFincaUseCase = eliminarFincaUseCase;
        this.obtenerFincaUseCase = obtenerFincaUseCase;
    }


    @Override
    public Finca actualizarFinca(Finca finca) {
        return actualizarFincaUseCase.actualizarFinca(finca);
    }

    @Override
    public Finca crearFinca(Finca finca) {
        return crearFincaUseCase.crearFinca(finca);
    }

    @Override
    public Boolean eliminarFincaPorId(Long id) {
        return eliminarFincaUseCase.eliminarFincaPorId(id);
    }

    @Override
    public List<Finca> obtenerFincas() {
        return obtenerFincaUseCase.obtenerFincas();
    }

    @Override
    public Finca obtenerFincaPorId(Long id) {
        return obtenerFincaUseCase.obtenerFincaPorId(id);
    }
}
