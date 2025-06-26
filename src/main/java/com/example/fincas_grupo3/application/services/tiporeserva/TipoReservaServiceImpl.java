package com.example.fincas_grupo3.application.services.tiporeserva;

import com.example.fincas_grupo3.application.dto.tiporeserva.TipoReservaRequestDTO;
import com.example.fincas_grupo3.application.dto.tiporeserva.TipoReservaResponseDTO;
import com.example.fincas_grupo3.application.mappers.tiporeserva.TipoReservaMapper;
import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;
import com.example.fincas_grupo3.domain.ports.in.tiporeserva.TipoReservaInPort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoReservaServiceImpl implements TipoReservaService {

    private final TipoReservaInPort tipoReservaInPort;
    private final TipoReservaMapper tipoReservaMapper;

    public TipoReservaServiceImpl(TipoReservaInPort tipoReservaInPort, TipoReservaMapper tipoReservaMapper) {
        this.tipoReservaInPort = tipoReservaInPort;
        this.tipoReservaMapper = tipoReservaMapper;
    }

    @Override
    public TipoReservaResponseDTO crearTipoReserva(TipoReservaRequestDTO requestDTO) {
        TipoReserva tipoReserva = tipoReservaMapper.toModel(requestDTO);
        return tipoReservaMapper.toDTO(tipoReservaInPort.crearTipoReserva(tipoReserva));
    }

    @Override
    public List<TipoReservaResponseDTO> obtenerTodos() {
        return tipoReservaInPort.obtenerTodosLosTiposReserva().stream()
                .map(tipoReservaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TipoReservaResponseDTO obtenerPorId(Long id) {
        return tipoReservaMapper.toDTO(tipoReservaInPort.obtenerTipoReservaPorId(id));
    }

    @Override
    public TipoReservaResponseDTO actualizarTipoReserva(TipoReservaRequestDTO requestDTO) {
        tipoReservaInPort.obtenerTipoReservaPorId(requestDTO.getId());
        TipoReserva tipoReserva = tipoReservaMapper.toModel(requestDTO);
        return tipoReservaMapper.toDTO(tipoReservaInPort.actualizarTipoReserva(tipoReserva));
    }

    @Override
    public void eliminarTipoReserva(Long id) {
        tipoReservaInPort.obtenerTipoReservaPorId(id);
        tipoReservaInPort.eliminarTipoReservaPorId(id);
    }
}