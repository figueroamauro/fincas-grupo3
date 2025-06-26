package com.example.fincas_grupo3.infrastructure.adapters.direccion;


import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import com.example.fincas_grupo3.domain.ports.out.direccion.DireccionOutPort;
import com.example.fincas_grupo3.infrastructure.Mappers.direccion.DireccionMapper;
import com.example.fincas_grupo3.infrastructure.entities.direccion.DireccionEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.direccion.JPADireccionRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionAdapter implements DireccionOutPort {

    private final JPADireccionRepository direccionRepository;
    private final DireccionMapper direccionMapper;

    public DireccionAdapter(JPADireccionRepository direccionRepository, DireccionMapper direccionMapper) {
        this.direccionRepository = direccionRepository;
        this.direccionMapper = direccionMapper;
    }

    @Override
    public Direccion guardar(Direccion direccion) {
        DireccionEntidad entidad = direccionMapper.toEntity(direccion);
        DireccionEntidad entidadGuardada = direccionRepository.save(entidad);
        return direccionMapper.toModel(entidadGuardada);
    }

    @Override
    public Direccion actualizar(Direccion direccion) {
        DireccionEntidad entidad = direccionMapper.toEntity(direccion);
        DireccionEntidad entidadGuardada = direccionRepository.save(entidad);
        return direccionMapper.toModel(entidadGuardada);
    }

    @Override
    public List<Direccion> obtenerTodas() {
        return direccionRepository.findAll().stream()
                .map(direccionMapper::toModel)
                .toList();
    }

    @Override
    public Direccion obtenerPorId(Long id) {
        return direccionRepository.findById(id)
                .map(direccionMapper::toModel)
                .orElse(null);
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        direccionRepository.deleteById(id);
        return true;
    }
}
