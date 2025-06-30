package com.example.fincas_grupo3.application.services.ciudad;

import com.example.fincas_grupo3.application.dto.ciudad.CiudadRequestDTO;
import com.example.fincas_grupo3.application.dto.ciudad.CiudadResponseDTO;
import com.example.fincas_grupo3.application.exceptions.CiudadNoEncontradaException;
import com.example.fincas_grupo3.application.mappers.ciudad.CiudadMapper;
import com.example.fincas_grupo3.application.usecases.ciudad.CiudadUseCases;
import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service


public class CiudadServiceImpl implements CiudadService {

    private final CiudadUseCases ciudadUseCases;

    public CiudadServiceImpl(CiudadUseCases ciudadUseCases) {
        this.ciudadUseCases = ciudadUseCases;
    }

    @Override
    public CiudadResponseDTO crearCiudad(CiudadRequestDTO dto) {
        Ciudad model = CiudadMapper.toModel(dto);
        Ciudad ciudadGuardada = ciudadUseCases.crearCiudadUseCase(model);
        return CiudadMapper.toDTO(ciudadGuardada);
    }

    @Override
    public CiudadResponseDTO actualizarCiudad(CiudadRequestDTO dto) {
        Ciudad ciudadEncontrada = ciudadUseCases.obtenerCiudadPorId(dto.getId());

        if (ciudadEncontrada == null) {
            throw new IllegalArgumentException("No se encontró la ciudad con el ID: " + dto.getId());
        }

        ciudadEncontrada.setNombre(dto.getNombre());

        Ciudad ciudadActualizada = ciudadUseCases.actualizarCiudadUseCase(ciudadEncontrada);
        return CiudadMapper.toDTO(ciudadActualizada);
    }

    @Override
    public List<CiudadResponseDTO> obtenerCiudades() {
        return ciudadUseCases.obtenerCiudades()
                .stream()
                .map(CiudadMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CiudadResponseDTO obtenerCiudadPorId(Long id) {
        Ciudad ciudad = ciudadUseCases.obtenerCiudadPorId(id);
        if (ciudad == null) {
            throw new CiudadNoEncontradaException("Ciudad no encontrada");
        }
        return CiudadMapper.toDTO(ciudad);
    }

    @Override
    public Boolean eliminarCiudad(CiudadRequestDTO dto) {
        Ciudad model = CiudadMapper.toModel(dto);
        return ciudadUseCases.eliminarCiudad(model);
    }

    @Override
    public Boolean eliminarCiudadPorId(Long id) {
        Ciudad ciudadEncontrada = ciudadUseCases.obtenerCiudadPorId(id);
        if (ciudadEncontrada == null) {
            throw new CiudadNoEncontradaException("Ciudad no encontrada");
        }
        return ciudadUseCases.eliminarCiudadPorId(id);
    }
}