package com.example.fincas_grupo3.application.services.factura;

import com.example.fincas_grupo3.application.dto.factura.FacturaRequestDTO;
import com.example.fincas_grupo3.application.dto.factura.FacturaResponseDTO;
import com.example.fincas_grupo3.application.mappers.factura.FacturaMapper;
import com.example.fincas_grupo3.domain.models.factura.Factura;
import com.example.fincas_grupo3.domain.ports.in.factura.FacturaInPort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaServiceImpl implements FacturaService {

    private final FacturaInPort facturaInPort;
    private final FacturaMapper facturaMapper;

    public FacturaServiceImpl(FacturaInPort facturaInPort, FacturaMapper facturaMapper) {
        this.facturaInPort = facturaInPort;
        this.facturaMapper = facturaMapper;
    }

    @Override
    public FacturaResponseDTO crearFactura(FacturaRequestDTO requestDTO) {
        Factura factura = facturaMapper.toModel(requestDTO);
        return facturaMapper.toDTO(facturaInPort.crearFactura(factura));
    }

    @Override
    public List<FacturaResponseDTO> obtenerTodas() {
        return facturaInPort.obtenerTodasLasFacturas().stream()
                .map(facturaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FacturaResponseDTO obtenerPorId(Long id) {
        return facturaMapper.toDTO(facturaInPort.obtenerFacturaPorId(id));
    }

    @Override
    public FacturaResponseDTO actualizarFactura(FacturaRequestDTO requestDTO) {
        facturaInPort.obtenerFacturaPorId(requestDTO.getId());
        Factura factura = facturaMapper.toModel(requestDTO);
        return facturaMapper.toDTO(facturaInPort.actualizarFactura(factura));
    }

    @Override
    public void eliminarFactura(Long id) {
        facturaInPort.obtenerFacturaPorId(id);
        facturaInPort.eliminarFacturaPorId(id);
    }
}