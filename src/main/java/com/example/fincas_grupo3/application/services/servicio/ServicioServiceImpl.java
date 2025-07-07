package com.example.fincas_grupo3.application.services.servicio;

import com.example.fincas_grupo3.application.dto.servicio.ServicioRequestDTO;
import com.example.fincas_grupo3.application.dto.servicio.ServicioResponseDTO;
import com.example.fincas_grupo3.application.exceptions.ServicioNoEncontradoException;
import com.example.fincas_grupo3.application.mappers.servicio.ServicioMapper;

import com.example.fincas_grupo3.application.usecases.servicio.ServiciosUseCases;
import com.example.fincas_grupo3.domain.models.servicio.Servicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {

    private final ServicioMapper servicioMapper;
    private final ServiciosUseCases serviciosUseCases;

    public ServicioServiceImpl(ServicioMapper servicioMapper, ServiciosUseCases serviciosUseCase) {
        this.servicioMapper = servicioMapper;
        this.serviciosUseCases = serviciosUseCase;
    }

    @Override
    public ServicioResponseDTO crearServicio(ServicioRequestDTO dto) {
        Servicio model = servicioMapper.toModel(dto);
        Servicio servicioGuardada = serviciosUseCases.crearServicio(model);
        return servicioMapper.toDTO(servicioGuardada);
    }

    @Override
    public ServicioResponseDTO actualizarServicio(ServicioRequestDTO dto) {
        verificarSiExisteServicio(dto.getId());

        Servicio model = servicioMapper.toModel(dto);
        Servicio servicioActualizado = serviciosUseCases.actualizarServicio(model);
        return servicioMapper.toDTO(servicioActualizado);
    }

    @Override
    public List<ServicioResponseDTO> obtenerServicios() {
        return serviciosUseCases.obtenerServicios().stream()
                .map(servicioMapper::toDTO)
                .toList();
    }

    @Override
    public ServicioResponseDTO obtenerServicioPorId(Long id) {
        Servicio servicio = verificarSiExisteServicio(id);
        return servicioMapper.toDTO(servicio);
    }

    @Override
    public Boolean eliminarServicioPorId(Long id) {
        verificarSiExisteServicio(id);
        return serviciosUseCases.eliminarServicioPorId(id);
    }

    private Servicio verificarSiExisteServicio(Long id) {
        Servicio servicio = serviciosUseCases.obtenerServicioPorId(id);
        if (servicio == null) {
            throw new ServicioNoEncontradoException("Servicio no encontrado");
        }
        return servicio;
    }
}
