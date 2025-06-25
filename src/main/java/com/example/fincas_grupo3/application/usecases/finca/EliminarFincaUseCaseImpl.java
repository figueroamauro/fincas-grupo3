package com.example.fincas_grupo3.application.usecases.finca;

import com.example.fincas_grupo3.domain.ports.in.finca.EliminarFincaUseCase;
import com.example.fincas_grupo3.domain.ports.out.finca.FincaOutPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarFincaUseCaseImpl implements EliminarFincaUseCase {
    private final FincaOutPort fincaOutPort;

    public EliminarFincaUseCaseImpl(FincaOutPort fincaOutPort) {
        this.fincaOutPort = fincaOutPort;
    }

    @Override
    public Boolean eliminarFincaPorId(Long id) {
        return fincaOutPort.eliminarPorId(id);
    }
}
