package com.example.fincas_grupo3.infrastructure.adapters.reserva;

import com.example.fincas_grupo3.application.exceptions.ReservaNoEncontradaException;
import com.example.fincas_grupo3.domain.models.reserva.Reserva;
import com.example.fincas_grupo3.domain.ports.out.reserva.ReservaOutPort;
import com.example.fincas_grupo3.infrastructure.Mappers.reserva.ReservaMapper;
import com.example.fincas_grupo3.infrastructure.entities.reserva.ReservaEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.reserva.JPAReservaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservaAdapter implements ReservaOutPort {

    private final JPAReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;

    public ReservaAdapter(JPAReservaRepository reservaRepository, ReservaMapper reservaMapper) {
        this.reservaRepository = reservaRepository;
        this.reservaMapper = reservaMapper;
    }

    @Override
    public Reserva crearReserva(Reserva reserva) {
        ReservaEntidad reservaEntidad = reservaMapper.toEntity(reserva);
        ReservaEntidad entidadGuardada = reservaRepository.save(reservaEntidad);
        return reservaMapper.toModel(entidadGuardada);
    }

    @Override
    public Reserva actualizarReserva(Reserva reserva) {

        ReservaEntidad reservaEntidad = reservaMapper.toEntity(reserva);
        ReservaEntidad entidadGuardada = reservaRepository.save(reservaEntidad);
        return reservaMapper.toModel(entidadGuardada);
    }

    @Override
    public List<Reserva> obtenerReservas() {
        return reservaRepository.findAll().stream()
                .map(reservaMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Reserva obtenerReservasPorId(Long id) {
        return reservaRepository.findById(id)
                .map(reservaMapper::toModel)
                .orElseThrow(() -> new ReservaNoEncontradaException("Reserva con id " + id + " no encontrada"));
    }

    @Override
    public Boolean eliminarReserva(Reserva reserva) {
        if (reserva.getId() != null && reservaRepository.existsById(reserva.getId())) {
            ReservaEntidad reservaEntidad = reservaMapper.toEntity(reserva);
            reservaRepository.delete(reservaEntidad);
            return true;
        }
        return false;
    }

    @Override
    public Boolean eliminarReservaPorId(Long id) {
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}