package com.example.fincas_grupo3.application.services.estadoPago;

import com.example.fincas_grupo3.application.dto.estadoPago.EstadoPagoRequestDTO;
import com.example.fincas_grupo3.application.dto.estadoPago.EstadoPagoResponseDTO;
import com.example.fincas_grupo3.application.mappers.estadoPago.EstadoPagoMapper;
import com.example.fincas_grupo3.domain.models.estadoPago.EstadoPago;
import com.example.fincas_grupo3.domain.ports.in.estadoPago.EstadoPagoInPort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoPagoServiceImpl implements EstadoPagoService {

    private final EstadoPagoInPort estadoPagoInPort;
    private final EstadoPagoMapper estadoPagoMapper;

    public EstadoPagoServiceImpl(EstadoPagoInPort estadoPagoInPort, EstadoPagoMapper estadoPagoMapper) {
        this.estadoPagoInPort = estadoPagoInPort;
        this.estadoPagoMapper = estadoPagoMapper;
    }

    @Override
    public EstadoPagoResponseDTO crearEstadoPago(EstadoPagoRequestDTO requestDTO) {
        EstadoPago estadoPago = estadoPagoMapper.toModel(requestDTO);
        return estadoPagoMapper.toDTO(estadoPagoInPort.crearEstadoPago(estadoPago));
    }

    @Override
    public List<EstadoPagoResponseDTO> obtenerTodos() {
        return estadoPagoInPort.obtenerTodosLosEstadosReserva().stream()
                .map(estadoPagoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EstadoPagoResponseDTO obtenerPorId(Long id) {
        return estadoPagoMapper.toDTO(estadoPagoInPort.obtenerEstadoPagoPorId(id));
    }

    @Override
    public EstadoPagoResponseDTO actualizarEstadoPago(EstadoPagoRequestDTO requestDTO) {
        estadoPagoInPort.obtenerEstadoPagoPorId(requestDTO.getId());
        EstadoPago estadoPago = estadoPagoMapper.toModel(requestDTO);
        return estadoPagoMapper.toDTO(estadoPagoInPort.actualizarEstadoPago(estadoPago));
    }

    @Override
    public void eliminarEstadoPago(Long id) {
        estadoPagoInPort.obtenerEstadoPagoPorId(id);
        estadoPagoInPort.eliminarEstadoPagoPorId(id);
    }
}