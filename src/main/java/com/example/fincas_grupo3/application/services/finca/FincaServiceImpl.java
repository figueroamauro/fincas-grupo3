package com.example.fincas_grupo3.application.services.finca;

import com.example.fincas_grupo3.application.dto.finca.FincaRequestDTO;
import com.example.fincas_grupo3.application.dto.finca.FincaResponseDTO;
import com.example.fincas_grupo3.application.exceptions.FincaNoEncontradaException;
import com.example.fincas_grupo3.application.mappers.finca.FincaMapper;
import com.example.fincas_grupo3.application.usecases.finca.FincaUseCases;
import com.example.fincas_grupo3.domain.models.finca.Finca;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FincaServiceImpl implements FincaService {
    private final FincaMapper fincaMapper;
    private final FincaUseCases fincaUseCases;

    public FincaServiceImpl(FincaMapper fincaMapper, FincaUseCases fincaUseCases) {
        this.fincaMapper = fincaMapper;
        this.fincaUseCases = fincaUseCases;
    }

    @Override
    public FincaResponseDTO guardar(FincaRequestDTO dto) {
        Finca model = fincaMapper.toModel(dto);
        Finca fincaGuardada = fincaUseCases.crearFinca(model);

        return fincaMapper.toDTO(fincaGuardada);
    }

    @Override
    public FincaResponseDTO actualizar(FincaRequestDTO dto) {
        verificarSiExisteFinca(dto.getId());

        Finca model = fincaMapper.toModel(dto);
        Finca fincaActualizada = fincaUseCases.actualizarFinca(model);

        return fincaMapper.toDTO(fincaActualizada);
    }

    @Override
    public List<FincaResponseDTO> obetenerTodas() {
        return fincaUseCases.obtenerFincas().stream().map(fincaMapper::toDTO).toList();
    }

    @Override
    public FincaResponseDTO obtenerPorId(Long id) {
        Finca finca = verificarSiExisteFinca(id);
        return fincaMapper.toDTO(finca);

    }

    @Override
    public Boolean eliminarPorId(Long id) {
        verificarSiExisteFinca(id);
        return fincaUseCases.eliminarFincaPorId(id);
    }

    private Finca verificarSiExisteFinca(Long id) {
        Finca finca = fincaUseCases.obtenerFincaPorId(id);

        if (finca == null) {
            throw new FincaNoEncontradaException("Finca no encontrada");
        }
        return finca;
    }
}
