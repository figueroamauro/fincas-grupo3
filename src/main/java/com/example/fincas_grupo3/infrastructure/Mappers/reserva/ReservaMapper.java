package com.example.fincas_grupo3.infrastructure.Mappers.reserva;

import com.example.fincas_grupo3.application.exceptions.ProvinciaNoEncontradaException;
import com.example.fincas_grupo3.domain.models.reserva.Reserva;
import com.example.fincas_grupo3.infrastructure.entities.estadoreserva.EstadoReservaEntidad;
import com.example.fincas_grupo3.infrastructure.entities.provincia.ProvinciaEntidad;
import com.example.fincas_grupo3.infrastructure.entities.reserva.ReservaEntidad;
import com.example.fincas_grupo3.infrastructure.repositories.estadoreserva.JPAEstadoReservaRepository;
import com.example.fincas_grupo3.infrastructure.repositories.provincia.JPAProvinciaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", implementationName = "reservaMapperInfra")
public abstract class ReservaMapper {

    @Autowired
    private JPAEstadoReservaRepository jpaEstadoReservaRepository;

    @Mapping(target = "estadoReserva", source = "estadoReservaEntidad")
    public abstract Reserva toModel(ReservaEntidad entidad);

    @Mapping(source = "estadoReserva.id", target = "estadoReservaEntidad", qualifiedByName = "mapEstadoIdtoEstadoEntidad")
    public abstract ReservaEntidad toEntity(Reserva reserva);


    @Named("mapEstadoIdtoEstadoEntidad")
    protected EstadoReservaEntidad mapEstadoIdtoEstadoEntidad(Long estadoId) {
        if (estadoId == null) {
            return null;
        }
        return jpaEstadoReservaRepository.findById(estadoId)
                .orElseThrow(() -> new ProvinciaNoEncontradaException("Estado reserva con id " + estadoId + " no encontrada al mapear la ciudad."));
    }
}