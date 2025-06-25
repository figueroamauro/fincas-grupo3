package com.example.fincas_grupo3.application.usecases.finca;

import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.domain.ports.in.finca.ActualizarFincaUseCase;
import com.example.fincas_grupo3.domain.ports.out.finca.FincaOutPort;
import org.springframework.stereotype.Service;

@Service
public class ActualizarFincaUseCaseImpl implements ActualizarFincaUseCase {
    private final FincaOutPort fincaOutPort;

    public ActualizarFincaUseCaseImpl(FincaOutPort fincaOutPort) {
        this.fincaOutPort = fincaOutPort;
    }

    @Override
    public Finca actualizarFinca(Finca finca) {
        return fincaOutPort.actualizar(finca);
    }
}
