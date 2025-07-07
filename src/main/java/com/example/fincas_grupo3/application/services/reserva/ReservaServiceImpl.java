package com.example.fincas_grupo3.application.services.reserva;

import com.example.fincas_grupo3.application.dto.reserva.ReservaRequestDTO;
import com.example.fincas_grupo3.application.dto.reserva.ReservaResponseDTO;
import com.example.fincas_grupo3.application.mappers.reserva.ReservaMapper;
import com.example.fincas_grupo3.domain.models.reserva.Reserva;
import com.example.fincas_grupo3.domain.ports.in.reserva.ReservaInPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaInPort reservaInPort;
    private final ReservaMapper reservaMapper;

    public ReservaServiceImpl(ReservaInPort reservaInPort, ReservaMapper reservaMapper) {
        this.reservaInPort = reservaInPort;
        this.reservaMapper = reservaMapper;
    }

    @Override
    public ReservaResponseDTO guardar(ReservaRequestDTO dto) {
        Reserva model = reservaMapper.toModel(dto);
        Reserva reservaGuardada = reservaInPort.crearReserva(model);
        return reservaMapper.toDTO(reservaGuardada);
    }

    @Override
    public ReservaResponseDTO actualizar(ReservaRequestDTO dto) {
        Reserva reservaEncontrada = reservaInPort.obtenerReservaPorId(dto.getId());

        if (reservaEncontrada == null) {
            throw new IllegalArgumentException("No se encontro la reserva con el id: " + dto.getId());
        }

        // Actualizamos el modelo encontrado con los datos del DTO
        reservaEncontrada.setFechaInicio(dto.getFechaInicio());
        reservaEncontrada.setFechaFin(dto.getFechaFin());
        reservaEncontrada.setPrecioTotal(dto.getPrecioTotal());

        Reserva reservaActualizada = reservaInPort.actualizarReserva(reservaEncontrada);
        return reservaMapper.toDTO(reservaActualizada);
    }

    @Override
    public List<ReservaResponseDTO> obtenerTodas() {
        return reservaInPort.obtenerReservas().stream()
                .map(reservaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservaResponseDTO obtenerPorId(Long id) {
        Reserva reservaGuardada = reservaInPort.obtenerReservaPorId(id);
        if (reservaGuardada == null) {
            throw new IllegalArgumentException("No se encontro la reserva con el id: " + id);
        }
        return reservaMapper.toDTO(reservaGuardada);
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        Reserva reservaEncontrada = reservaInPort.obtenerReservaPorId(id);
        if (reservaEncontrada != null) {
            return reservaInPort.eliminarReservaPorId(id);
        }
        return false;
    }
}