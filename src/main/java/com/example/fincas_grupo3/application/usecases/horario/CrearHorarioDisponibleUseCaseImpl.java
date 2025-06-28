package com.example.fincas_grupo3.application.usecases.horario;

import com.example.fincas_grupo3.domain.models.horario.HorarioDisponible;
import com.example.fincas_grupo3.domain.ports.in.horario.CrearHorarioDisponibleUseCase;
import com.example.fincas_grupo3.domain.ports.out.horario.HorarioDisponibleOutPort;
import org.springframework.stereotype.Service;

@Service
public class CrearHorarioDisponibleUseCaseImpl implements CrearHorarioDisponibleUseCase {
    private final HorarioDisponibleOutPort horarioDisponibleOutPort;

    public CrearHorarioDisponibleUseCaseImpl(HorarioDisponibleOutPort horarioDisponibleOutPort) {
        this.horarioDisponibleOutPort = horarioDisponibleOutPort;
    }

    @Override
    public HorarioDisponible crearHorarioDisponible(HorarioDisponible horarioDisponible) {
        return horarioDisponibleOutPort.guardar(horarioDisponible);
    }
}
