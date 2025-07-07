package com.example.fincas_grupo3.application.usecases.finca;

import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.domain.ports.in.finca.CrearFincaUseCase;
import com.example.fincas_grupo3.domain.ports.out.finca.FincaOutPort;
import org.springframework.stereotype.Service;

@Service
public class CrearFincaUseCaseImpl implements CrearFincaUseCase {
    private final FincaOutPort fincaOutPort;

    public CrearFincaUseCaseImpl(FincaOutPort fincaOutPort) {
        this.fincaOutPort = fincaOutPort;
    }

    @Override
    public Finca crearFinca(Finca finca) {
        return fincaOutPort.guardar(finca);
    }

}
