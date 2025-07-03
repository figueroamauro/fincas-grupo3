package com.example.fincas_grupo3.application.services.finca;

import com.example.fincas_grupo3.application.dto.finca.FincaRequestDTO;
import com.example.fincas_grupo3.application.dto.finca.FincaResponseDTO;
import com.example.fincas_grupo3.application.exceptions.DireccionNoEncontradaException;
import com.example.fincas_grupo3.application.exceptions.FincaNoEncontradaException;
import com.example.fincas_grupo3.application.exceptions.UsuarioNoEncontradoException;
import com.example.fincas_grupo3.application.mappers.finca.FincaMapper;
import com.example.fincas_grupo3.application.usecases.direccion.DireccionUseCases; // <-- 1. IMPORTAR
import com.example.fincas_grupo3.application.usecases.finca.FincaUseCases;
import com.example.fincas_grupo3.application.usecases.usuario.UsuarioUseCases;   // <-- 1. IMPORTAR
import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FincaServiceImpl implements FincaService {
    private final FincaMapper fincaMapper;
    private final FincaUseCases fincaUseCases;

    private final DireccionUseCases direccionUseCases;
    private final UsuarioUseCases usuarioUseCases;


    public FincaServiceImpl(FincaMapper fincaMapper, FincaUseCases fincaUseCases, DireccionUseCases direccionUseCases, UsuarioUseCases usuarioUseCases) {
        this.fincaMapper = fincaMapper;
        this.fincaUseCases = fincaUseCases;
        this.direccionUseCases = direccionUseCases;
        this.usuarioUseCases = usuarioUseCases;
    }

    @Override
    public FincaResponseDTO guardar(FincaRequestDTO dto) {

        Finca model = fincaMapper.toModel(dto);


        Direccion direccionCompleta = direccionUseCases.obtenerDireccionPorId(dto.getDireccionId());
        if (direccionCompleta == null) {
            throw new DireccionNoEncontradaException("La dirección con id " + dto.getDireccionId() + " no fue encontrada.");
        }


        Usuario usuarioCompleto = usuarioUseCases.obtenerUsuarioPorId(dto.getUsuarioId());
        if (usuarioCompleto == null) {
            throw new UsuarioNoEncontradoException("El usuario con id " + dto.getUsuarioId() + " no fue encontrado.");
        }


        model.setDireccion(direccionCompleta);
        model.setUsuario(usuarioCompleto);


        Finca fincaGuardada = fincaUseCases.crearFinca(model);


        return fincaMapper.toDTO(fincaGuardada);
    }

    @Override
    public FincaResponseDTO actualizar(FincaRequestDTO dto) {
        verificarSiExisteFinca(dto.getId());

        Finca model = fincaMapper.toModel(dto);


        Direccion direccionCompleta = direccionUseCases.obtenerDireccionPorId(dto.getDireccionId());
        if (direccionCompleta == null) {
            throw new DireccionNoEncontradaException("La dirección con id " + dto.getDireccionId() + " no fue encontrada.");
        }

        Usuario usuarioCompleto = usuarioUseCases.obtenerUsuarioPorId(dto.getUsuarioId());
        if (usuarioCompleto == null) {
            throw new UsuarioNoEncontradoException("El usuario con id " + dto.getUsuarioId() + " no fue encontrado.");
        }

        model.setDireccion(direccionCompleta);
        model.setUsuario(usuarioCompleto);

        Finca fincaActualizada = fincaUseCases.actualizarFinca(model);
        return fincaMapper.toDTO(fincaActualizada);
    }

    @Override
    public List<FincaResponseDTO> obetenerTodas() {

        return fincaUseCases.obtenerFincas().stream()
                .map(fincaMapper::toDTO)
                .collect(Collectors.toList());
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