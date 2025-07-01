package com.example.fincas_grupo3.application.services.estadopublicacion;

import com.example.fincas_grupo3.application.dto.estadopublicacion.EstadoPublicacionRequestDTO;
import com.example.fincas_grupo3.application.dto.estadopublicacion.EstadoPublicacionResponseDTO;
import com.example.fincas_grupo3.application.mappers.estadopublicacion.EstadoPublicacionMapper;
import com.example.fincas_grupo3.domain.models.estadopublicacion.EstadoPublicacion;
import com.example.fincas_grupo3.application.usecases.estadopublicacion.EstadoPublicacionUseCases;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoPublicacionServiceImpl implements EstadoPublicacionService {

    private final EstadoPublicacionMapper mapper;
    private final EstadoPublicacionUseCases useCases;

    public EstadoPublicacionServiceImpl(EstadoPublicacionMapper mapper, EstadoPublicacionUseCases useCases) {
        this.mapper = mapper;
        this.useCases = useCases;
    }

    @Override
    public EstadoPublicacionResponseDTO guardar(EstadoPublicacionRequestDTO dto) {
        EstadoPublicacion model = mapper.toModel(dto);
        EstadoPublicacion guardado = useCases.guardar(model);
        return mapper.toDTO(guardado);
    }

    @Override
    public EstadoPublicacionResponseDTO actualizar(EstadoPublicacionRequestDTO dto) {
        EstadoPublicacion actualizarEstadoPublicacion = useCases.actualizarEstadoPublicacion(mapper.toModel(dto));
        return mapper.toDTO(actualizarEstadoPublicacion);
    }

    @Override
    public List<EstadoPublicacionResponseDTO> obtenerTodas() {
        return useCases.obtenerEstadoPublicaciones()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EstadoPublicacionResponseDTO obtenerPorId(Long id) {
        return mapper.toDTO(useCases.obtenerEstadoPublicacionPorId(id));
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        return useCases.eliminarEstadoPublicacionPorId(id);
    }
}
