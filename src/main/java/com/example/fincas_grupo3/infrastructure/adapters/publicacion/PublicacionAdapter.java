package com.example.fincas_grupo3.infrastructure.adapters.publicacion;
import com.example.fincas_grupo3.application.exceptions.PublicacionNoEncontradaException;
import com.example.fincas_grupo3.domain.models.publicacion.Publicacion;
import com.example.fincas_grupo3.domain.ports.out.publicacion.PublicacionOutPort;
import com.example.fincas_grupo3.infrastructure.entities.publicacion.PublicacionEntidad;
import com.example.fincas_grupo3.infrastructure.mappers.publicacion.PublicacionMapper;
import com.example.fincas_grupo3.infrastructure.repositories.publicacion.JPAPublicacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionAdapter implements PublicacionOutPort {

    private final JPAPublicacionRepository jpaPublicacionRepository;
    private final PublicacionMapper publicacionMapper;

    public PublicacionAdapter(JPAPublicacionRepository jpaPublicacionRepository, PublicacionMapper publicacionMapper) {
        this.jpaPublicacionRepository = jpaPublicacionRepository;
        this.publicacionMapper = publicacionMapper;
    }

    @Override
    public Publicacion guardar(Publicacion publicacion) {
        PublicacionEntidad entidad = publicacionMapper.toEntity(publicacion);
        PublicacionEntidad entidadGuardada = jpaPublicacionRepository.save(entidad);
        return publicacionMapper.toModel(entidadGuardada);
    }

    @Override
    public Publicacion actualizar(Publicacion publicacion) {
        PublicacionEntidad entidad = publicacionMapper.toEntity(publicacion);
        PublicacionEntidad entidadActualizada = jpaPublicacionRepository.save(entidad);
        return publicacionMapper.toModel(entidadActualizada);
    }

    @Override
    public List<Publicacion> obtenerTodas() {
        return jpaPublicacionRepository.findAll()
                .stream()
                .map(publicacionMapper::toModel)
                .toList();
    }

    @Override
    public Publicacion obtenerPorId(Long id) {
        return jpaPublicacionRepository.findById(id)
                .map(publicacionMapper::toModel)
                .orElseThrow(() -> new PublicacionNoEncontradaException("No se encontró la publicación con ID: " + id));
    }


    @Override
    public Boolean eliminarPorId(Long id) {
        if (jpaPublicacionRepository.existsById(id)) {
            jpaPublicacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
