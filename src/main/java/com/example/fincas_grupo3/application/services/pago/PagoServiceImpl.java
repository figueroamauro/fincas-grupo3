package com.example.fincas_grupo3.application.services.pago;

import com.example.fincas_grupo3.application.dto.pago.PagoRequestDTO;
import com.example.fincas_grupo3.application.dto.pago.PagoResponseDTO;
import com.example.fincas_grupo3.application.mappers.pago.PagoMapper;
import com.example.fincas_grupo3.domain.models.pago.Pago;
import com.example.fincas_grupo3.domain.ports.in.pago.PagoInPort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoInPort pagoInPort;
    private final PagoMapper pagoMapper;

    public PagoServiceImpl(PagoInPort pagoInPort, PagoMapper pagoMapper) {
        this.pagoInPort = pagoInPort;
        this.pagoMapper = pagoMapper;
    }

    @Override
    public PagoResponseDTO crearPago(PagoRequestDTO requestDTO) {
        Pago pago = pagoMapper.toModel(requestDTO);
        return pagoMapper.toDTO(pagoInPort.crearPago(pago));
    }

    @Override
    public List<PagoResponseDTO> obtenerTodos() {
        return pagoInPort.obtenerTodosLosPagos().stream()
                .map(pagoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PagoResponseDTO obtenerPorId(Long id) {
        return pagoMapper.toDTO(pagoInPort.obtenerPagoPorId(id));
    }

    @Override
    public PagoResponseDTO actualizarPago(PagoRequestDTO requestDTO) {
        pagoInPort.obtenerPagoPorId(requestDTO.getId());
        Pago pago = pagoMapper.toModel(requestDTO);
        return pagoMapper.toDTO(pagoInPort.actualizarPago(pago));
    }

    @Override
    public void eliminarPago(Long id) {
        pagoInPort.obtenerPagoPorId(id);
        pagoInPort.eliminarPagoPorId(id);
    }
}