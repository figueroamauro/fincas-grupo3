package com.example.fincas_grupo3.application.services.descuento;


import com.example.fincas_grupo3.application.dto.descuento.DescuentoRequestDTO;
import com.example.fincas_grupo3.application.dto.descuento.DescuentoResponseDTO;
import com.example.fincas_grupo3.application.exceptions.DescuentoNoEncontradoException;
import com.example.fincas_grupo3.application.mappers.descuento.DescuentoMapper;
import com.example.fincas_grupo3.application.usecases.descuento.DescuentoUseCases;
import com.example.fincas_grupo3.domain.models.descuento.Descuento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescuentoServiceImpl implements DescuentoService {

    private final DescuentoMapper descuentoMapper;
    private final DescuentoUseCases descuentoUseCases;

    public DescuentoServiceImpl(DescuentoMapper descuentoMapper, DescuentoUseCases descuentoUseCases) {
        this.descuentoMapper = descuentoMapper;
        this.descuentoUseCases = descuentoUseCases;
    }

    @Override
    public DescuentoResponseDTO guardar(DescuentoRequestDTO dto) {
        Descuento model = descuentoMapper.toModel(dto);
        Descuento descuentoGuardada = descuentoUseCases.crearDescuento(model);
        return descuentoMapper.toDTO(descuentoGuardada);
    }

    @Override
    public DescuentoResponseDTO actualizar(DescuentoRequestDTO dto) {
        verificarSiExisteDescuento(dto.getId());

        Descuento model = descuentoMapper.toModel(dto);
        Descuento descuentoActualizada = descuentoUseCases.actualizarDescuento(model);
        return descuentoMapper.toDTO(descuentoActualizada);
    }

    @Override
    public List<DescuentoResponseDTO> obtenerTodas() {
        return descuentoUseCases.obtenerDescuentos().stream()
                .map(descuentoMapper::toDTO)
                .toList();  
    }

    @Override
    public DescuentoResponseDTO obtenerPorId(Long id) {
        Descuento descuento = verificarSiExisteDescuento(id);
        return descuentoMapper.toDTO(descuento);
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        verificarSiExisteDescuento(id);
        return descuentoUseCases.eliminarDescuentoPorId(id);
    }

    private Descuento verificarSiExisteDescuento(Long id) {
        Descuento descuento = descuentoUseCases.obtenerDescuentoPorId(id);
        if (descuento == null) {
            throw new DescuentoNoEncontradoException("Descuento no encontrado");
        }
        return descuento;
    }
}
