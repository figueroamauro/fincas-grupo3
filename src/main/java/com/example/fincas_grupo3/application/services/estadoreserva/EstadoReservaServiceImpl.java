package com.example.fincas_grupo3.application.services.estadoreserva;

import com.example.fincas_grupo3.application.dto.estadoreserva.EstadoReservaRequestDTO;
import com.example.fincas_grupo3.application.dto.estadoreserva.EstadoReservaResponseDTO;
import com.example.fincas_grupo3.application.mappers.estadoreserva.EstadoReservaMapper;
import com.example.fincas_grupo3.domain.models.estadoreserva.EstadoReserva;
import com.example.fincas_grupo3.domain.ports.in.estadoreserva.EstadoReservaInPort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoReservaServiceImpl implements EstadoReservaService {

    private final EstadoReservaInPort estadoReservaInPort;
    private final EstadoReservaMapper estadoReservaMapper;

    public EstadoReservaServiceImpl(EstadoReservaInPort estadoReservaInPort, EstadoReservaMapper estadoReservaMapper) {
        this.estadoReservaInPort = estadoReservaInPort;
        this.estadoReservaMapper = estadoReservaMapper;
    }

    @Override
    public EstadoReservaResponseDTO crearEstadoReserva(EstadoReservaRequestDTO requestDTO) {
        EstadoReserva estadoReserva = estadoReservaMapper.toModel(requestDTO);
        return estadoReservaMapper.toDTO(estadoReservaInPort.crearEstadoReserva(estadoReserva));
    }

    @Override
    public List<EstadoReservaResponseDTO> obtenerTodos() {
        return estadoReservaInPort.obtenerTodosLosEstadosReserva().stream()
                .map(estadoReservaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EstadoReservaResponseDTO obtenerPorId(Long id) {
        return estadoReservaMapper.toDTO(estadoReservaInPort.obtenerEstadoReservaPorId(id));
    }

    @Override
    public EstadoReservaResponseDTO actualizarEstadoReserva(EstadoReservaRequestDTO requestDTO) {
        estadoReservaInPort.obtenerEstadoReservaPorId(requestDTO.getId());
        EstadoReserva estadoReserva = estadoReservaMapper.toModel(requestDTO);
        return estadoReservaMapper.toDTO(estadoReservaInPort.actualizarEstadoReserva(estadoReserva));
    }

    @Override
    public void eliminarEstadoReserva(Long id) {
        estadoReservaInPort.obtenerEstadoReservaPorId(id);
        estadoReservaInPort.eliminarEstadoReservaPorId(id);
    }
}