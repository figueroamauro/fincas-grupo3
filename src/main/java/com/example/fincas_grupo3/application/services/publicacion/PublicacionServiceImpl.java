package com.example.fincas_grupo3.application.services.publicacion;

import com.example.fincas_grupo3.application.dto.publicacion.PublicacionRequestDTO;
import com.example.fincas_grupo3.application.dto.publicacion.PublicacionResponseDTO;
import com.example.fincas_grupo3.application.mappers.publicacion.PublicacionMapper;
import com.example.fincas_grupo3.application.usecases.publicacion.PublicacionUseCases;
import com.example.fincas_grupo3.domain.models.publicacion.Publicacion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    private final PublicacionMapper publicacionMapper;
    private final PublicacionUseCases publicacionUseCases;

    public PublicacionServiceImpl(PublicacionMapper publicacionMapper, PublicacionUseCases publicacionUseCases) {
        this.publicacionMapper = publicacionMapper;
        this.publicacionUseCases = publicacionUseCases;
    }

    @Override
    public PublicacionResponseDTO guardar(PublicacionRequestDTO dto) {
        Publicacion model = publicacionMapper.toModel(dto);
        Publicacion guardada = publicacionUseCases.crearPublicacion(model); // ← CORREGIDO
        return publicacionMapper.toDTO(guardada);
    }

    @Override
    public PublicacionResponseDTO actualizar(PublicacionRequestDTO dto) {
        verificarSiExiste(dto.getId());
        Publicacion model = publicacionMapper.toModel(dto);
        Publicacion actualizada = publicacionUseCases.actualizarPublicacion(model);
        return publicacionMapper.toDTO(actualizada);
    }

    @Override
    public List<PublicacionResponseDTO> obtenerTodas() {
        return publicacionUseCases.obtenerPublicaciones()
                .stream()
                .map(publicacionMapper::toDTO)
                .toList();
    }

    @Override
    public PublicacionResponseDTO obtenerPorId(Long id) {
        Publicacion publicacion = verificarSiExiste(id);
        return publicacionMapper.toDTO(publicacion);
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        verificarSiExiste(id);
        return publicacionUseCases.eliminarPublicacionPorId(id);
    }

    private Publicacion verificarSiExiste(Long id) {
        return publicacionUseCases.obtenerPublicacionPorId(id);
    }
}

