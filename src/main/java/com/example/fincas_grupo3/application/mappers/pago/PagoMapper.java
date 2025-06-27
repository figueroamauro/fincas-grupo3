package com.example.fincas_grupo3.application.mappers.pago;

import com.example.fincas_grupo3.application.dto.pago.PagoRequestDTO;
import com.example.fincas_grupo3.application.dto.pago.PagoResponseDTO;
import com.example.fincas_grupo3.domain.models.pago.Pago;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "pagoMapperApplication")
public abstract class PagoMapper {
    public abstract Pago toModel(PagoRequestDTO requestDTO);
    public abstract PagoResponseDTO toDTO(Pago pago);
}