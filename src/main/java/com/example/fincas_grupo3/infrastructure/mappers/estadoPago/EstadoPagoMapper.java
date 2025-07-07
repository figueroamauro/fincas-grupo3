package com.example.fincas_grupo3.infrastructure.mappers.estadoPago;

import com.example.fincas_grupo3.domain.models.estadoPago.EstadoPago;

import com.example.fincas_grupo3.infrastructure.entities.estadoPago.EstadoPagoEntidad;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "estadoPagoMapperInfrav")

public abstract class EstadoPagoMapper {
    public abstract EstadoPago toModel(EstadoPagoEntidad entidad);
    public abstract EstadoPagoEntidad toEntity(EstadoPago estadoPago);
}