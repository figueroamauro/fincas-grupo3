package com.example.fincas_grupo3.application.services.foto;

import com.example.fincas_grupo3.application.dto.foto.FotoRequestDTO;
import com.example.fincas_grupo3.application.dto.foto.FotoResponseDTO;
import com.example.fincas_grupo3.application.exceptions.FotoNoEncontradaException;
import com.example.fincas_grupo3.application.mappers.foto.FotoMapper;
import com.example.fincas_grupo3.application.usecases.foto.FotoUseCases;
import com.example.fincas_grupo3.domain.models.foto.Foto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FotoServiceImpl implements FotoService {
    private final FotoUseCases fotoUseCases;
    private final FotoMapper fotoMapper;

    public FotoServiceImpl(FotoUseCases fotoUseCases, FotoMapper fotoMapper) {
        this.fotoUseCases = fotoUseCases;
        this.fotoMapper = fotoMapper;
    }

    @Override
    public FotoResponseDTO guardar(FotoRequestDTO dto) {
        Foto model = fotoMapper.toModel(dto);
        Foto fotoGuardada = fotoUseCases.crearFoto(model);

        return fotoMapper.toDTO(fotoGuardada);
    }

    @Override
    public FotoResponseDTO actualizar(FotoRequestDTO dto) {
        verificarSiExisteFoto(dto.getId());

        Foto model = fotoMapper.toModel(dto);
        Foto fotoActualizada = fotoUseCases.actualizarFoto(model);

        return fotoMapper.toDTO(fotoActualizada);
    }

    @Override
    public List<FotoResponseDTO> obtenerTodas() {
        return fotoUseCases.obtenerFotos().stream().map(fotoMapper::toDTO).toList();
    }

    @Override
    public FotoResponseDTO obtenerPorId(Long id) {
        Foto foto = verificarSiExisteFoto(id);

        return fotoMapper.toDTO(foto);
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        verificarSiExisteFoto(id);

        return fotoUseCases.eliminarFotoPorId(id);
    }

    private Foto verificarSiExisteFoto(Long id) {
        Foto foto = fotoUseCases.obtenerFotoPorId(id);
        if (foto == null) {
            throw new FotoNoEncontradaException("Foto no encontrada");
        }
        return foto;
    }
}
