package com.example.fincas_grupo3.infrastructure.mappers.estadoreserva;

import com.example.fincas_grupo3.domain.models.estadoreserva.EstadoReserva;
import com.example.fincas_grupo3.infrastructure.entities.estadoreserva.EstadoReservaEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "estadoReservaMapperInfra")
public abstract class EstadoReservaMapper {
    public abstract EstadoReserva toModel(EstadoReservaEntidad entidad);
    public abstract EstadoReservaEntidad toEntity(EstadoReserva estadoReserva);
}