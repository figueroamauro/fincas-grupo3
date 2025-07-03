package com.example.fincas_grupo3.infrastructure.adapters.tipoFactura;

import com.example.fincas_grupo3.application.exceptions.TipoFacturaNoEncontradaException;
import com.example.fincas_grupo3.domain.models.tipoFactura.TipoFactura;
import com.example.fincas_grupo3.domain.ports.out.tipoFactura.TipoFacturaOutPort;
import com.example.fincas_grupo3.infrastructure.mappers.tipoFactura.TipoFacturaMapper;
import com.example.fincas_grupo3.infrastructure.entities.tipoFactura.TipoFacturaEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.tipoFactura.JPATipoFacturaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TipoFacturaAdapter implements TipoFacturaOutPort {

    private final JPATipoFacturaRepository tipoFacturaRepository;
    private final TipoFacturaMapper tipoFacturaMapper;

    public TipoFacturaAdapter(JPATipoFacturaRepository tipoFacturaRepository, TipoFacturaMapper tipoFacturaMapper) {
        this.tipoFacturaRepository = tipoFacturaRepository;
        this.tipoFacturaMapper = tipoFacturaMapper;
    }

    @Override
    public TipoFactura save(TipoFactura tipoFactura) {
        TipoFacturaEntidad entidad = tipoFacturaMapper.toEntity(tipoFactura);
        return tipoFacturaMapper.toModel(tipoFacturaRepository.save(entidad));
    }

    @Override
    public TipoFactura update(TipoFactura tipoFactura) {
        TipoFacturaEntidad entidad = tipoFacturaMapper.toEntity(tipoFactura);
        return tipoFacturaMapper.toModel(tipoFacturaRepository.save(entidad));
    }

    @Override
    public TipoFactura findById(Long id) {
        return tipoFacturaRepository.findById(id)
                .map(tipoFacturaMapper::toModel)
                .orElseThrow(() -> new TipoFacturaNoEncontradaException("Tipo de factura no encontrado con id: " + id));
    }

    @Override
    public List<TipoFactura> findAll() {
        return tipoFacturaRepository.findAll().stream()
                .map(tipoFacturaMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Long id) {
        if (tipoFacturaRepository.existsById(id)) {
            tipoFacturaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}