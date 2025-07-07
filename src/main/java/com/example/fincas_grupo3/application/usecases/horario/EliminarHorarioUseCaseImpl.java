package com.example.fincas_grupo3.application.usecases.horario;

import com.example.fincas_grupo3.domain.ports.in.horario.EliminarHorarioDisponibleUseCase;
import com.example.fincas_grupo3.domain.ports.out.horario.HorarioDisponibleOutPort;
import org.springframework.stereotype.Service;

@Service
public class EliminarHorarioUseCaseImpl implements EliminarHorarioDisponibleUseCase {
    private final HorarioDisponibleOutPort horarioDisponibleOutPort;

    public EliminarHorarioUseCaseImpl(HorarioDisponibleOutPort horarioDisponibleOutPort) {
        this.horarioDisponibleOutPort = horarioDisponibleOutPort;
    }



    @Override
    public Boolean eliminarHorarioDisponiblePorId(Long id) {
        return horarioDisponibleOutPort.eliminarPorId(id);
    }
}
