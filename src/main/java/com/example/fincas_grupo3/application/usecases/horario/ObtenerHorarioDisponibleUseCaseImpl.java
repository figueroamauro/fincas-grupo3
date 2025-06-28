package com.example.fincas_grupo3.application.usecases.horario;

import com.example.fincas_grupo3.domain.models.horario.HorarioDisponible;
import com.example.fincas_grupo3.domain.ports.in.horario.ObtenerHorarioDisponibleUseCase;
import com.example.fincas_grupo3.domain.ports.out.horario.HorarioDisponibleOutPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerHorarioDisponibleUseCaseImpl implements ObtenerHorarioDisponibleUseCase {
    private final HorarioDisponibleOutPort horarioDisponibleOutPort;

    public ObtenerHorarioDisponibleUseCaseImpl(HorarioDisponibleOutPort horarioDisponibleOutPort) {
        this.horarioDisponibleOutPort = horarioDisponibleOutPort;
    }

    @Override
    public List<HorarioDisponible> obtenerHorariosDisponibles() {
        return horarioDisponibleOutPort.obtenerTodos();
    }

    @Override
    public HorarioDisponible obtenerHorarioDisponiblePorId(Long id) {
        return horarioDisponibleOutPort.obtenerPorId(id);
    }
}
