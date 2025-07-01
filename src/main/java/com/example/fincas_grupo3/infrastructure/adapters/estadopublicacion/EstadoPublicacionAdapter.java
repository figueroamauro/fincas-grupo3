package com.example.fincas_grupo3.infrastructure.adapters.estadopublicacion;

import com.example.fincas_grupo3.application.exceptions.EstadoPublicacionNoEncontradaException;
import com.example.fincas_grupo3.domain.models.estadopublicacion.EstadoPublicacion;
import com.example.fincas_grupo3.domain.ports.out.estadopublicacion.EstadoPublicacionOutPort;
import com.example.fincas_grupo3.infrastructure.Mappers.estadopublicacion.EstadoPublicacionMapper;
import com.example.fincas_grupo3.infrastructure.entities.estadopublicacion.EstadoPublicacionEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.estadopublicacion.JPAEstadoPublicacionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstadoPublicacionAdapter implements EstadoPublicacionOutPort {

    private final JPAEstadoPublicacionRepository estadoPublicacionRepository;
    private final EstadoPublicacionMapper estadoPublicacionMapper;

    public EstadoPublicacionAdapter(JPAEstadoPublicacionRepository estadoPublicacionRepository,
                                    EstadoPublicacionMapper estadoPublicacionMapper) {
        this.estadoPublicacionRepository = estadoPublicacionRepository;
        this.estadoPublicacionMapper = estadoPublicacionMapper;
    }

    @Override
    public EstadoPublicacion guardar(EstadoPublicacion estadoPublicacion) {
        EstadoPublicacionEntidad entidad = estadoPublicacionMapper.toEntity(estadoPublicacion);
        EstadoPublicacionEntidad guardada = estadoPublicacionRepository.save(entidad);
        return estadoPublicacionMapper.toModel(guardada);
    }

    @Override
    public EstadoPublicacion actualizar(EstadoPublicacion estadoPublicacion) {
        EstadoPublicacionEntidad entidad = estadoPublicacionMapper.toEntity(estadoPublicacion);
        EstadoPublicacionEntidad actualizada = estadoPublicacionRepository.save(entidad);
        return estadoPublicacionMapper.toModel(actualizada);
    }

    @Override
    public EstadoPublicacion obtenerPorId(Long id) {
        return estadoPublicacionRepository.findById(id)
                .map(estadoPublicacionMapper::toModel)
                .orElseThrow(() -> new EstadoPublicacionNoEncontradaException("No se encontró el estado con ID: " + id));
    }

    @Override
    public List<EstadoPublicacion> obtenerTodas() {
        return estadoPublicacionRepository.findAll().stream()
                .map(estadoPublicacionMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        if (estadoPublicacionRepository.existsById(id)) {
            estadoPublicacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

