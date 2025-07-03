package com.example.fincas_grupo3.infrastructure.mappers.reserva;

import com.example.fincas_grupo3.domain.models.reserva.Reserva;
import com.example.fincas_grupo3.infrastructure.entities.reserva.ReservaEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "reservaMapperInfra")
public abstract class ReservaMapper {

    public abstract Reserva toModel(ReservaEntidad entidad);

    public abstract ReservaEntidad toEntity(Reserva reserva);
}