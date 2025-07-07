package com.example.fincas_grupo3.infrastructure.adapters.estadoreserva;

import com.example.fincas_grupo3.application.exceptions.EstadoReservaNoEncontradoException;
import com.example.fincas_grupo3.domain.models.estadoreserva.EstadoReserva;
import com.example.fincas_grupo3.domain.ports.out.estadoreserva.EstadoReservaOutPort;
import com.example.fincas_grupo3.infrastructure.mappers.estadoreserva.EstadoReservaMapper;
import com.example.fincas_grupo3.infrastructure.entities.estadoreserva.EstadoReservaEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.estadoreserva.JPAEstadoReservaRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstadoReservaAdapter implements EstadoReservaOutPort {

    private final JPAEstadoReservaRepository estadoReservaRepository;
    private final EstadoReservaMapper estadoReservaMapper;

    public EstadoReservaAdapter(JPAEstadoReservaRepository estadoReservaRepository, EstadoReservaMapper estadoReservaMapper) {
        this.estadoReservaRepository = estadoReservaRepository;
        this.estadoReservaMapper = estadoReservaMapper;
    }

    @Override
    public EstadoReserva save(EstadoReserva estadoReserva) {
        EstadoReservaEntidad entidad = estadoReservaMapper.toEntity(estadoReserva);
        return estadoReservaMapper.toModel(estadoReservaRepository.save(entidad));
    }

    @Override
    public EstadoReserva update(EstadoReserva estadoReserva) {
        EstadoReservaEntidad entidad = estadoReservaMapper.toEntity(estadoReserva);
        return estadoReservaMapper.toModel(estadoReservaRepository.save(entidad));
    }

    @Override
    public EstadoReserva findById(Long id) {
        return estadoReservaRepository.findById(id)
                .map(entidad -> estadoReservaMapper.toModel(entidad))
                .orElseThrow(() -> new EstadoReservaNoEncontradoException("Estado de reserva no encontrado con id: " + id));
    }

    @Override
    public List<EstadoReserva> findAll() {
        return estadoReservaRepository.findAll().stream()
                .map(entidad -> estadoReservaMapper.toModel(entidad))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Long id) {
        if (estadoReservaRepository.existsById(id)) {
            estadoReservaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}