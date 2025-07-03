package com.example.fincas_grupo3.application.mappers.reserva;

import com.example.fincas_grupo3.application.dto.reserva.ReservaRequestDTO;
import com.example.fincas_grupo3.application.dto.reserva.ReservaResponseDTO;
import com.example.fincas_grupo3.application.exceptions.EstadoReservaNoEncontradoException;
import com.example.fincas_grupo3.application.exceptions.FincaNoEncontradaException;
import com.example.fincas_grupo3.application.exceptions.TipoReservaNoEncontradoException;
import com.example.fincas_grupo3.application.mappers.finca.FincaMapper;
import com.example.fincas_grupo3.application.mappers.usuario.UsuarioMapper;
import com.example.fincas_grupo3.application.usecases.estadoreserva.EstadoReservaUseCases;
import com.example.fincas_grupo3.application.usecases.finca.FincaUseCases;
import com.example.fincas_grupo3.application.usecases.tiporeserva.TipoReservaUseCases;
import com.example.fincas_grupo3.application.usecases.usuario.UsuarioUseCases;
import com.example.fincas_grupo3.domain.models.estadoreserva.EstadoReserva;
import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.domain.models.reserva.Reserva;
import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;
import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",
        uses = {UsuarioMapper.class, FincaMapper.class}, // <-- Se agregan los mappers que se van a usar
        implementationName = "reservaMapperApplication")
public abstract class ReservaMapper {

    @Autowired
    protected EstadoReservaUseCases estadoReservaUseCases;
    @Autowired
    protected UsuarioUseCases usuarioUseCases;
    @Autowired
    protected FincaUseCases fincaUseCases;
    @Autowired
    protected TipoReservaUseCases tipoReservaUseCases;

    @Mapping(source = "estadoId", target = "estadoReserva", qualifiedByName = "mapEstadoIdToEstado")
    @Mapping(source = "usuarioId", target = "usuario", qualifiedByName = "mapUsuarioIdToUsuario")
    @Mapping(source = "fincaId", target = "finca", qualifiedByName = "mapFincaIdToFinca")
    @Mapping(source = "tipoReservaId", target = "tipoReserva", qualifiedByName = "mapTipoReservaIdToTipoReserva")
    public abstract Reserva toModel(ReservaRequestDTO requestDTO);

    @Mapping(source = "estadoReserva.nombre", target = "nombreEstado")
    @Mapping(source = "tipoReserva.nombre", target = "nombreTipoReserva")
    @Mapping(source = "usuario", target = "usuario")
    @Mapping(source = "finca", target = "finca")
    public abstract ReservaResponseDTO toDTO(Reserva reserva);

    @Named("mapEstadoIdToEstado")
    protected EstadoReserva mapEstadoIdToEstado(Long estadoId) {
        EstadoReserva estadoReserva = estadoReservaUseCases.obtenerEstadoReservaPorId(estadoId);
        if (estadoReserva == null) {
            throw new EstadoReservaNoEncontradoException("Estado reserva con id " + estadoId + " no encontrada.");
        }
        return estadoReserva;
    }

    @Named("mapUsuarioIdToUsuario")
    protected Usuario mapUsuarioIdToUsuario(Long usuarioId) {
        Usuario usuario = usuarioUseCases.obtenerUsuarioPorId(usuarioId);
        if (usuario == null) {
            throw new EntityNotFoundException("Usuario con id " + usuarioId + " no encontrado.");
        }
        return usuario;
    }

    @Named("mapFincaIdToFinca")
    protected Finca mapFincaIdToFinca(Long fincaId) {
        Finca finca = fincaUseCases.obtenerFincaPorId(fincaId);
        if (finca == null) {
            throw new FincaNoEncontradaException("Finca con id " + fincaId + " no encontrada.");
        }
        return finca;
    }

    @Named("mapTipoReservaIdToTipoReserva")
    protected TipoReserva mapTipoReservaIdToTipoReserva(Long tipoReservaId) {
        TipoReserva tipoReserva = tipoReservaUseCases.obtenerTipoReservaPorId(tipoReservaId);
        if (tipoReserva == null) {
            throw new TipoReservaNoEncontradoException("Tipo de reserva con id " + tipoReservaId + " no encontrado.");
        }
        return tipoReserva;
    }
}