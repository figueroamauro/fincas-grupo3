package com.example.fincas_grupo3.application.mappers.estadoPago;

import com.example.fincas_grupo3.application.dto.estadoPago.EstadoPagoRequestDTO;
import com.example.fincas_grupo3.application.dto.estadoPago.EstadoPagoResponseDTO;
import com.example.fincas_grupo3.domain.models.estadoPago.EstadoPago;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "estadoPagoMapperApplication")
public abstract class EstadoPagoMapper {
    public abstract EstadoPago toModel(EstadoPagoRequestDTO requestDTO);
    public abstract EstadoPagoResponseDTO toDTO(EstadoPago estadoPago);
}
