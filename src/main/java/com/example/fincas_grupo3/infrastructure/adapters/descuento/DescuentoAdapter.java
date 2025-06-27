package com.example.fincas_grupo3.infrastructure.adapters.descuento;

import com.example.fincas_grupo3.infrastructure.Mappers.descuento.DescuentoMapper;
import com.example.fincas_grupo3.domain.models.descuento.Descuento;
import com.example.fincas_grupo3.domain.ports.out.descuento.DescuentoOutPort;
import com.example.fincas_grupo3.infrastructure.entities.descuento.DescuentoEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.descuento.JPADescuentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescuentoAdapter implements DescuentoOutPort {

    private final JPADescuentoRepository descuentoRepository;
    private final DescuentoMapper descuentoMapper;

    public DescuentoAdapter(JPADescuentoRepository descuentoRepository, DescuentoMapper descuentoMapper) {
        this.descuentoRepository = descuentoRepository;
        this.descuentoMapper = descuentoMapper;
    }

    @Override
    public Descuento guardar(Descuento descuento) {
        DescuentoEntidad entidad = descuentoMapper.toEntity(descuento);
        DescuentoEntidad entidadGuardada = descuentoRepository.save(entidad);
        return descuentoMapper.toModel(entidadGuardada);
    }

    @Override
    public Descuento actualizar(Descuento descuento) {
        DescuentoEntidad entidad = descuentoMapper.toEntity(descuento);
        DescuentoEntidad entidadGuardada = descuentoRepository.save(entidad);
        return descuentoMapper.toModel(entidadGuardada);
    }

    @Override
    public List<Descuento> obtenerTodas() {
        return descuentoRepository.findAll().stream()
                .map(descuentoMapper::toModel)
                .toList();
    }

    @Override
    public Descuento obtenerPorId(Long id) {
        return descuentoRepository.findById(id)
                .map(descuentoMapper::toModel)
                .orElse(null);
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        descuentoRepository.deleteById(id);
        return true;
    }
}
