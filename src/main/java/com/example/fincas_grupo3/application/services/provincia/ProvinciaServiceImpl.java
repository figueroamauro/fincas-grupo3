package com.example.fincas_grupo3.application.services.provincia;

import com.example.fincas_grupo3.application.dto.provincia.ProvinciaRequestDTO;
import com.example.fincas_grupo3.application.dto.provincia.ProvinciaResponseDTO;
import com.example.fincas_grupo3.application.exceptions.ProvinciaNoEncontradaException;
import com.example.fincas_grupo3.application.mappers.provincia.ProvinciaMapper;
import com.example.fincas_grupo3.application.usecases.provincia.ProvinciaUseCases;
import com.example.fincas_grupo3.domain.models.provincia.Provincia;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {
    private final ProvinciaMapper provinciaMapper;
    private final ProvinciaUseCases provinciaUseCases;

    public ProvinciaServiceImpl(ProvinciaMapper provinciaMapper, ProvinciaUseCases provinciaUseCases) {
        this.provinciaMapper = provinciaMapper;
        this.provinciaUseCases = provinciaUseCases;
    }

    @Override
    public ProvinciaResponseDTO guardar(ProvinciaRequestDTO dto) {
        Provincia model = provinciaMapper.toModel(dto);
        Provincia provinciaGuardada = provinciaUseCases.crearProvincia(model);


        return provinciaMapper.ToDTO(provinciaGuardada);
    }

    @Override
    public ProvinciaResponseDTO actualizar(ProvinciaRequestDTO dto) {
        verificarSiExisteProvincia(dto.getId());

        Provincia model = provinciaMapper.toModel(dto);
        Provincia provinciaActualizada = provinciaUseCases.actualizarProvincia(model);


        return provinciaMapper.ToDTO(provinciaActualizada);
    }

    @Override
    public List<ProvinciaResponseDTO> obtenerTodas() {

        return provinciaUseCases.obtenerProvincias().stream().map(provinciaMapper::ToDTO).toList();
    }

    @Override
    public ProvinciaResponseDTO obtenerPorId(Long id) {
        Provincia provincia = verificarSiExisteProvincia(id);


        return provinciaMapper.ToDTO(provincia);
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        verificarSiExisteProvincia(id);
        return provinciaUseCases.eliminarProvinciaPorId(id);
    }

    private Provincia verificarSiExisteProvincia(Long id) {
        Provincia provincia = provinciaUseCases.obtenerProvinciaPorId(id);

        if (provincia == null) {
            throw new ProvinciaNoEncontradaException("Provincia con id " + id + " no encontrada");
        }
        return provincia;
    }
}