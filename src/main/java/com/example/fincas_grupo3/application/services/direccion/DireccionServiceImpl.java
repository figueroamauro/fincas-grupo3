package com.example.fincas_grupo3.application.services.direccion;

import com.example.fincas_grupo3.application.dto.direccion.DireccionRequestDTO;
import com.example.fincas_grupo3.application.dto.direccion.DireccionResponseDTO;
import com.example.fincas_grupo3.application.exceptions.DireccionNoEncontradaException;
import com.example.fincas_grupo3.application.mappers.direccion.DireccionMapper;
import com.example.fincas_grupo3.application.usecases.direccion.DireccionUseCases;
import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionServiceImpl implements DireccionService {

    private final DireccionMapper direccionMapper;
    private final DireccionUseCases direccionUseCases;

    public DireccionServiceImpl(DireccionMapper direccionMapper, DireccionUseCases direccionUseCases) {
        this.direccionMapper = direccionMapper;
        this.direccionUseCases = direccionUseCases;
    }

    @Override
    public DireccionResponseDTO guardar(DireccionRequestDTO dto) {
        Direccion model = direccionMapper.toModel(dto);
        Direccion direccionGuardada = direccionUseCases.crearDireccion(model);
        return direccionMapper.toDTO(direccionGuardada);
    }

    @Override
    public DireccionResponseDTO actualizar(DireccionRequestDTO dto) {
        verificarSiExisteDireccion(dto.getId());

        Direccion model = direccionMapper.toModel(dto);
        Direccion direccionActualizada = direccionUseCases.actualizarDireccion(model);
        return direccionMapper.toDTO(direccionActualizada);
    }

    @Override
    public List<DireccionResponseDTO> obtenerTodas() {
        return direccionUseCases.obtenerDirecciones().stream()
                .map(direccionMapper::toDTO)
                .toList();
    }

    @Override
    public DireccionResponseDTO obtenerPorId(Long id) {
        Direccion direccion = verificarSiExisteDireccion(id);
        return direccionMapper.toDTO(direccion);
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        verificarSiExisteDireccion(id);
        return direccionUseCases.eliminarDireccionPorId(id);
    }

    private Direccion verificarSiExisteDireccion(Long id) {
        Direccion direccion = direccionUseCases.obtenerDireccionPorId(id);
        if (direccion == null) {
            throw new DireccionNoEncontradaException("Dirección no encontrada");
        }
        return direccion;
    }
}
