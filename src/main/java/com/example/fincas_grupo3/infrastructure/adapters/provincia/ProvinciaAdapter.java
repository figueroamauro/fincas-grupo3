package com.example.fincas_grupo3.infrastructure.adapters.provincia;

import com.example.fincas_grupo3.domain.models.provincia.Provincia;
import com.example.fincas_grupo3.domain.ports.out.provincia.ProvinciaOutPort;
import com.example.fincas_grupo3.infrastructure.Mappers.provincia.ProvinciaMapper;
import com.example.fincas_grupo3.infrastructure.entities.provincia.ProvinciaEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.provincia.JPAProvinciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaAdapter implements ProvinciaOutPort {

    private final JPAProvinciaRepository jpaProvinciaRepository;
    private final ProvinciaMapper provinciaMapper;

    public ProvinciaAdapter(JPAProvinciaRepository jpaProvinciaRepository, ProvinciaMapper provinciaMapper) {
        this.jpaProvinciaRepository = jpaProvinciaRepository;
        this.provinciaMapper = provinciaMapper;
    }

    @Override
    public Provincia guardar(Provincia provincia) {
        ProvinciaEntidad entidad = provinciaMapper.toEntity(provincia);
        ProvinciaEntidad entidadGuardada = jpaProvinciaRepository.save(entidad);
        return provinciaMapper.toModel(entidadGuardada);
    }

    @Override
    public Provincia actualizar(Provincia provincia) {
        // La implementación es la misma que guardar, ya que .save() maneja ambas operaciones
        ProvinciaEntidad entidad = provinciaMapper.toEntity(provincia);
        ProvinciaEntidad entidadGuardada = jpaProvinciaRepository.save(entidad);
        return provinciaMapper.toModel(entidadGuardada);
    }

    @Override
    public List<Provincia> obtenerTodas() {
        return jpaProvinciaRepository.findAll().stream().map(provinciaMapper::toModel).toList();
    }

    @Override
    public Provincia obtenerPorId(Long id) {
        Optional<ProvinciaEntidad> provinciaGuardada = jpaProvinciaRepository.findById(id);
        if (provinciaGuardada.isPresent()) {
            return provinciaMapper.toModel(provinciaGuardada.get());
        }
        return null;
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        Optional<ProvinciaEntidad> provinciaEncontrada = jpaProvinciaRepository.findById(id);
        if (provinciaEncontrada.isPresent()) {
            jpaProvinciaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}