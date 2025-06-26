package com.example.fincas_grupo3.ciudades.application.services;

import com.example.fincas_grupo3.ciudades.application.dto.CiudadRequestDTO;
import com.example.fincas_grupo3.ciudades.application.dto.CiudadResponseDTO;
import com.example.fincas_grupo3.ciudades.application.mappers.CiudadMapper;
import com.example.fincas_grupo3.ciudades.application.usecases.CiudadUseCases;
import com.example.fincas_grupo3.ciudades.domain.models.Ciudad;
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
        return CiudadMapper.toDTO(ciudad);
    }

    @Override
    public Boolean eliminarCiudad(CiudadRequestDTO dto) {
        Ciudad model = CiudadMapper.toModel(dto);
        return ciudadUseCases.eliminarCiudad(model);
    }

    @Override
    public Boolean eliminarCiudadPorId(Long id) {
        return ciudadUseCases.eliminarCiudadPorId(id);
    }
}