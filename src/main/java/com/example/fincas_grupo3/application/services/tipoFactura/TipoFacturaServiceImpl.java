package com.example.fincas_grupo3.application.services.tipoFactura;

import com.example.fincas_grupo3.application.dto.tipoFactura.TipoFacturaRequestDTO;
import com.example.fincas_grupo3.application.dto.tipoFactura.TipoFacturaResponseDTO;
import com.example.fincas_grupo3.application.mappers.tipoFactura.TipoFacturaMapper;
import com.example.fincas_grupo3.domain.models.tipoFactura.TipoFactura;
import com.example.fincas_grupo3.domain.ports.in.tipoFactura.TipoFacturaInPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoFacturaServiceImpl implements TipoFacturaService {

    private final TipoFacturaInPort tipoFacturaInPort;
    private final TipoFacturaMapper tipoFacturaMapper;

    public TipoFacturaServiceImpl(TipoFacturaInPort tipoFacturaInPort, TipoFacturaMapper tipoFacturaMapper) {
        this.tipoFacturaInPort = tipoFacturaInPort;
        this.tipoFacturaMapper = tipoFacturaMapper;
    }

    @Override
    public TipoFacturaResponseDTO crearTipoFactura(TipoFacturaRequestDTO requestDTO) {
        TipoFactura tipoFactura = tipoFacturaMapper.toModel(requestDTO);
        return tipoFacturaMapper.toDTO(tipoFacturaInPort.crearTipoFactura(tipoFactura));
    }

    @Override
    public List<TipoFacturaResponseDTO> obtenerTodos() {
        return tipoFacturaInPort.obtenerTodosLosTiposFactura().stream()
                .map(tipoFacturaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TipoFacturaResponseDTO obtenerPorId(Long id) {
        return tipoFacturaMapper.toDTO(tipoFacturaInPort.obtenerTipoFacturaPorId(id));
    }

    @Override
    public TipoFacturaResponseDTO actualizarTipoFactura(TipoFacturaRequestDTO requestDTO) {
        tipoFacturaInPort.obtenerTipoFacturaPorId(requestDTO.getId());
        TipoFactura tipoFactura = tipoFacturaMapper.toModel(requestDTO);
        return tipoFacturaMapper.toDTO(tipoFacturaInPort.actualizarTipoFactura(tipoFactura));
    }

    @Override
    public void eliminarTipoFactura(Long id) {
        tipoFacturaInPort.obtenerTipoFacturaPorId(id);
        tipoFacturaInPort.eliminarTipoFacturaPorId(id);
    }
}