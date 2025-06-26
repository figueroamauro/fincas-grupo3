package com.example.fincas_grupo3.infrastructure.Mappers.tiporeserva;

import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;
import com.example.fincas_grupo3.infrastructure.entities.tiporeserva.TipoReservaEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "tipoReservaMapperInfra")
public abstract class TipoReservaMapper {
    public abstract TipoReserva toModel(TipoReservaEntidad entidad);
    public abstract TipoReservaEntidad toEntity(TipoReserva tipoReserva);
}