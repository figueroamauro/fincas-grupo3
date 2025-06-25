package com.example.fincas_grupo3.application.usecases.finca;

import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.domain.ports.in.finca.ObtenerFincaUseCase;
import com.example.fincas_grupo3.domain.ports.out.finca.FincaOutPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerFincaUseCaseImpl implements ObtenerFincaUseCase {
    private final FincaOutPort fincaOutPort;

    public ObtenerFincaUseCaseImpl(FincaOutPort fincaOutPort) {
        this.fincaOutPort = fincaOutPort;
    }

    @Override
    public List<Finca> obtenerFincas() {
        return fincaOutPort.obetenerTodas();
    }

    @Override
    public Finca obtenerFincaPorId(Long id) {
        return fincaOutPort.obtenerPorId(id);
    }
}
