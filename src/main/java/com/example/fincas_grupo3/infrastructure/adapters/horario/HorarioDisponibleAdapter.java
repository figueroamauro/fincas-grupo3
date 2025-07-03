package com.example.fincas_grupo3.infrastructure.adapters.horario;

import com.example.fincas_grupo3.domain.models.horario.HorarioDisponible;
import com.example.fincas_grupo3.domain.ports.out.horario.HorarioDisponibleOutPort;
import com.example.fincas_grupo3.infrastructure.mappers.horario.HorarioDisponibleMapper;
import com.example.fincas_grupo3.infrastructure.entities.horario.HorarioDisponibleEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.horario.JPAHorarioDisponibleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioDisponibleAdapter implements HorarioDisponibleOutPort {
    private final JPAHorarioDisponibleRepository jpaHorarioDisponibleRepository;
    private final HorarioDisponibleMapper horarioDisponibleMapper;

    public HorarioDisponibleAdapter(JPAHorarioDisponibleRepository jpaHorarioDisponibleRepository, HorarioDisponibleMapper horarioDisponibleMapper) {
        this.jpaHorarioDisponibleRepository = jpaHorarioDisponibleRepository;
        this.horarioDisponibleMapper = horarioDisponibleMapper;
    }

    @Override
    public HorarioDisponible guardar(HorarioDisponible horarioDisponible) {
        HorarioDisponibleEntidad entidad = horarioDisponibleMapper.toEntidad(horarioDisponible);
        HorarioDisponibleEntidad horarioGuardado = jpaHorarioDisponibleRepository.save(entidad);
        return horarioDisponibleMapper.toModel(horarioGuardado);
    }

    @Override
    public List<HorarioDisponible> obtenerTodos() {
        return jpaHorarioDisponibleRepository.findAll().stream().map(horarioDisponibleMapper::toModel).toList();
    }

    @Override
    public HorarioDisponible obtenerPorId(Long id) {
        Optional<HorarioDisponibleEntidad> horarioEncontrado = jpaHorarioDisponibleRepository.findById(id);
        if (horarioEncontrado.isPresent()) {
            return horarioEncontrado.map(horarioDisponibleMapper::toModel).get();
        }
        return null;
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        Optional<HorarioDisponibleEntidad> horarioEncontrado = jpaHorarioDisponibleRepository.findById(id);
        if (horarioEncontrado.isEmpty()) {
            return false;
        }
        jpaHorarioDisponibleRepository.deleteById(id);
        return true;
    }
}
