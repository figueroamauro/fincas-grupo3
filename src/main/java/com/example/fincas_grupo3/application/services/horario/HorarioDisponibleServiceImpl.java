package com.example.fincas_grupo3.application.services.horario;

import com.example.fincas_grupo3.application.dto.horario.HorarioDisponibleRequestDTO;
import com.example.fincas_grupo3.application.dto.horario.HorarioDisponibleResponseDTO;
import com.example.fincas_grupo3.application.exceptions.HorarioNoEncontradoException;
import com.example.fincas_grupo3.application.mappers.horario.HorarioDisponibleMapper;
import com.example.fincas_grupo3.application.usecases.horario.HorarioDisponibleUseCases;
import com.example.fincas_grupo3.domain.models.horario.HorarioDisponible;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioDisponibleServiceImpl implements HorarioDisponibleService {
    private final HorarioDisponibleUseCases horarioDisponibleUseCases;
    private final HorarioDisponibleMapper horarioDisponibleMapper;

    public HorarioDisponibleServiceImpl(HorarioDisponibleUseCases horarioDisponibleUseCases, HorarioDisponibleMapper horarioDisponibleMapper) {
        this.horarioDisponibleUseCases = horarioDisponibleUseCases;
        this.horarioDisponibleMapper = horarioDisponibleMapper;
    }

    @Override
    public HorarioDisponibleResponseDTO guardar(HorarioDisponibleRequestDTO dto) {
        HorarioDisponible model = horarioDisponibleMapper.toModel(dto);
        model.getFinca().agregarHorario(model);
        HorarioDisponible horarioGuardado = horarioDisponibleUseCases.crearHorarioDisponible(model);
        return horarioDisponibleMapper.toDTO(horarioGuardado);
    }

    @Override
    public List<HorarioDisponibleResponseDTO> obtenerTodos() {
        return horarioDisponibleUseCases.obtenerHorariosDisponibles().stream().map(horarioDisponibleMapper::toDTO).toList();
    }

    @Override
    public HorarioDisponibleResponseDTO obtenerPorId(Long id) {
        HorarioDisponible horarioDisponible = validarHorarioEncontrado(id);
        return horarioDisponibleMapper.toDTO(horarioDisponible);
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        validarHorarioEncontrado(id);
        return horarioDisponibleUseCases.eliminarHorarioDisponiblePorId(id);
    }

    private HorarioDisponible validarHorarioEncontrado(Long id) {
        HorarioDisponible horarioDisponible = horarioDisponibleUseCases.obtenerHorarioDisponiblePorId(id);
        if (horarioDisponible == null) {
            throw new HorarioNoEncontradoException("Horario no encontrado");
        }
        return horarioDisponible;
    }
}
