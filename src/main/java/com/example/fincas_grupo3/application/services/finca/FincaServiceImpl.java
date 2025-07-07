package com.example.fincas_grupo3.application.services.finca;

import com.example.fincas_grupo3.application.dto.finca.FincaRequestDTO;
import com.example.fincas_grupo3.application.dto.finca.FincaResponseDTO;
import com.example.fincas_grupo3.application.exceptions.DireccionNoEncontradaException;
import com.example.fincas_grupo3.application.exceptions.FincaNoEncontradaException;
import com.example.fincas_grupo3.application.exceptions.ServicioNoEncontradoException;
import com.example.fincas_grupo3.application.exceptions.UsuarioNoEncontradoException;
import com.example.fincas_grupo3.application.mappers.finca.FincaMapper;
import com.example.fincas_grupo3.application.usecases.direccion.DireccionUseCases;
import com.example.fincas_grupo3.application.usecases.finca.FincaUseCases;
import com.example.fincas_grupo3.application.usecases.servicio.ServiciosUseCases;
import com.example.fincas_grupo3.application.usecases.tiporeserva.TipoReservaUseCases;
import com.example.fincas_grupo3.application.usecases.usuario.UsuarioUseCases;
import com.example.fincas_grupo3.domain.models.direccion.Direccion;
import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.domain.models.servicio.Servicio;
import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;
import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FincaServiceImpl implements FincaService {
    private final FincaMapper fincaMapper;
    private final FincaUseCases fincaUseCases;
    private final DireccionUseCases direccionUseCases;
    private final UsuarioUseCases usuarioUseCases;
    private final ServiciosUseCases serviciosUseCases;
    private final TipoReservaUseCases tipoReservaUseCases;

    public FincaServiceImpl(FincaMapper fincaMapper, FincaUseCases fincaUseCases, DireccionUseCases direccionUseCases, UsuarioUseCases usuarioUseCases, ServiciosUseCases serviciosUseCases, TipoReservaUseCases tipoReservaUseCases) {
        this.fincaMapper = fincaMapper;
        this.fincaUseCases = fincaUseCases;
        this.direccionUseCases = direccionUseCases;
        this.usuarioUseCases = usuarioUseCases;
        this.serviciosUseCases = serviciosUseCases;
        this.tipoReservaUseCases = tipoReservaUseCases;
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
        if (model.getTipoReservas().isEmpty()) {
            model.setTipoReservas(new HashSet<>());
            TipoReserva tipoReserva = tipoReservaUseCases.obtenerTipoReservaPorId(1L);
            model.getTipoReservas().add(tipoReserva);
        }


        if (dto.getServicioIds() != null && !dto.getServicioIds().isEmpty()) {
            Set<Servicio> serviciosCompletos = dto.getServicioIds().stream()
                    .map(id -> {
                        Servicio servicio = serviciosUseCases.obtenerServicioPorId(id);
                        if (servicio == null) {
                            throw new ServicioNoEncontradoException("Servicio con id " + id + " no encontrado.");
                        }
                        return servicio;
                    })
                    .collect(Collectors.toSet());
            model.setServicios(serviciosCompletos);
        } else {
            model.setServicios(Collections.emptySet());
        }

        Finca fincaGuardada = fincaUseCases.crearFinca(model);
        return fincaMapper.toDTO(fincaGuardada);
    }

    @Override
    public FincaResponseDTO actualizar(FincaRequestDTO dto) {

        Finca fincaExistente = verificarSiExisteFinca(dto.getId());


        Finca model = fincaMapper.toModel(dto);
        model.setId(fincaExistente.getId()); // Aseguramos que el ID sea el correcto


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


        if (dto.getServicioIds() != null && !dto.getServicioIds().isEmpty()) {
            Set<Servicio> serviciosCompletos = dto.getServicioIds().stream()
                    .map(id -> {
                        Servicio servicio = serviciosUseCases.obtenerServicioPorId(id);
                        if (servicio == null) {
                            throw new ServicioNoEncontradoException("Servicio con id " + id + " no encontrado.");
                        }
                        return servicio;
                    })
                    .collect(Collectors.toSet());
            model.setServicios(serviciosCompletos);
        } else {
            model.setServicios(Collections.emptySet());
        }

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
            throw new FincaNoEncontradaException("Finca con id " + id + " no encontrada");
        }
        return finca;
    }
}