package com.example.fincas_grupo3.infrastructure.Mappers.reserva;

import com.example.fincas_grupo3.application.exceptions.FincaNoEncontradaException;
import com.example.fincas_grupo3.application.exceptions.TipoReservaNoEncontradoException;
import com.example.fincas_grupo3.domain.models.reserva.Reserva;
import com.example.fincas_grupo3.infrastructure.Mappers.estadoreserva.EstadoReservaMapper;
import com.example.fincas_grupo3.infrastructure.Mappers.finca.FincaMapper;
import com.example.fincas_grupo3.infrastructure.Mappers.tiporeserva.TipoReservaMapper;
import com.example.fincas_grupo3.infrastructure.Mappers.usuario.UsuarioMapper;
import com.example.fincas_grupo3.infrastructure.entities.estadoreserva.EstadoReservaEntidad;
import com.example.fincas_grupo3.infrastructure.entities.finca.FincaEntidad;
import com.example.fincas_grupo3.infrastructure.entities.reserva.ReservaEntidad;
import com.example.fincas_grupo3.infrastructure.entities.tiporeserva.TipoReservaEntidad;
import com.example.fincas_grupo3.infrastructure.entities.usuario.UsuarioEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.estadoreserva.JPAEstadoReservaRepository;
import com.example.fincas_grupo3.infrastructure.repositories.finca.JPAFincaRepository;
import com.example.fincas_grupo3.infrastructure.repositories.tiporeserva.JPATipoReservaRepository;
import com.example.fincas_grupo3.infrastructure.repositories.usuario.JPAUsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",
        uses = {EstadoReservaMapper.class, UsuarioMapper.class, FincaMapper.class, TipoReservaMapper.class},
        implementationName = "reservaMapperInfra")
public abstract class ReservaMapper {

    @Autowired
    private JPAEstadoReservaRepository jpaEstadoReservaRepository;
    @Autowired
    private JPAUsuarioRepository jpaUsuarioRepository;
    @Autowired
    private JPAFincaRepository jpaFincaRepository;
    @Autowired
    private JPATipoReservaRepository jpaTipoReservaRepository;

    @Mapping(target = "estadoReserva", source = "estadoReservaEntidad")
    @Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "finca", source = "finca")
    @Mapping(target = "tipoReserva", source = "tipoReserva")
    public abstract Reserva toModel(ReservaEntidad entidad);

    @Mapping(source = "estadoReserva.id", target = "estadoReservaEntidad", qualifiedByName = "mapEstadoIdToEstadoEntidad")
    @Mapping(source = "usuario.id", target = "usuario", qualifiedByName = "mapUsuarioIdToUsuarioEntidad")
    @Mapping(source = "finca.id", target = "finca", qualifiedByName = "mapFincaIdToFincaEntidad")
    @Mapping(source = "tipoReserva.id", target = "tipoReserva", qualifiedByName = "mapTipoReservaIdToTipoReservaEntidad")
    public abstract ReservaEntidad toEntity(Reserva reserva);

    @Named("mapEstadoIdToEstadoEntidad")
    protected EstadoReservaEntidad mapEstadoIdToEstadoEntidad(Long estadoId) {
        return jpaEstadoReservaRepository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado de reserva con id " + estadoId + " no encontrado."));
    }

    @Named("mapUsuarioIdToUsuarioEntidad")
    protected UsuarioEntidad mapUsuarioIdToUsuarioEntidad(Long usuarioId) {
        return jpaUsuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario con id " + usuarioId + " no encontrado."));
    }

    @Named("mapFincaIdToFincaEntidad")
    protected FincaEntidad mapFincaIdToFincaEntidad(Long fincaId) {
        return jpaFincaRepository.findById(fincaId)
                .orElseThrow(() -> new FincaNoEncontradaException("Finca con id " + fincaId + " no encontrada."));
    }

    @Named("mapTipoReservaIdToTipoReservaEntidad")
    protected TipoReservaEntidad mapTipoReservaIdToTipoReservaEntidad(Long tipoReservaId) {
        return jpaTipoReservaRepository.findById(tipoReservaId)
                .orElseThrow(() -> new TipoReservaNoEncontradoException("Tipo de reserva con id " + tipoReservaId + " no encontrado."));
    }
}