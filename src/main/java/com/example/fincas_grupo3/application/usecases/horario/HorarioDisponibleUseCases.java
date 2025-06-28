package com.example.fincas_grupo3.application.usecases.horario;

import com.example.fincas_grupo3.domain.models.horario.HorarioDisponible;
import com.example.fincas_grupo3.domain.ports.in.horario.CrearHorarioDisponibleUseCase;
import com.example.fincas_grupo3.domain.ports.in.horario.EliminarHorarioDisponibleUseCase;
import com.example.fincas_grupo3.domain.ports.in.horario.HorarioDisponibleInPort;
import com.example.fincas_grupo3.domain.ports.in.horario.ObtenerHorarioDisponibleUseCase;
import com.example.fincas_grupo3.domain.ports.in.provincia.EliminarProvinciaUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioDisponibleUseCases implements HorarioDisponibleInPort {
    private final CrearHorarioDisponibleUseCase crearHorarioDisponibleUseCase;
    private final ObtenerHorarioDisponibleUseCase obtenerHorarioDisponibleUseCase;
    private final EliminarHorarioDisponibleUseCase eliminarHorarioDisponibleUseCase;

    public HorarioDisponibleUseCases(CrearHorarioDisponibleUseCase crearHorarioDisponibleUseCase, ObtenerHorarioDisponibleUseCase obtenerHorarioDisponibleUseCase, EliminarHorarioDisponibleUseCase eliminarHorarioDisponibleUseCase) {
        this.crearHorarioDisponibleUseCase = crearHorarioDisponibleUseCase;
        this.obtenerHorarioDisponibleUseCase = obtenerHorarioDisponibleUseCase;
        this.eliminarHorarioDisponibleUseCase = eliminarHorarioDisponibleUseCase;
    }

    @Override
    public HorarioDisponible crearHorarioDisponible(HorarioDisponible horarioDisponible) {
        return crearHorarioDisponibleUseCase.crearHorarioDisponible(horarioDisponible);
    }

    @Override
    public List<HorarioDisponible> obtenerHorariosDisponibles() {
        return obtenerHorarioDisponibleUseCase.obtenerHorariosDisponibles();
    }

    @Override
    public HorarioDisponible obtenerHorarioDisponiblePorId(Long id) {
        return obtenerHorarioDisponibleUseCase.obtenerHorarioDisponiblePorId(id);
    }

    @Override
    public Boolean eliminarHorarioDisponiblePorId(Long id) {
        return eliminarHorarioDisponibleUseCase.eliminarHorarioDisponiblePorId(id);
    }
}
