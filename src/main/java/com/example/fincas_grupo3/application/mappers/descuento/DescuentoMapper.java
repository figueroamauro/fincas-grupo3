package com.example.fincas_grupo3.application.mappers.descuento;

import com.example.fincas_grupo3.application.dto.descuento.DescuentoRequestDTO;
import com.example.fincas_grupo3.application.dto.descuento.DescuentoResponseDTO;
import com.example.fincas_grupo3.domain.models.descuento.Descuento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",implementationName = "descuentoMapperApplication")

public abstract class DescuentoMapper {

    public abstract Descuento toModel(DescuentoRequestDTO dto);

    public abstract DescuentoResponseDTO toDTO(Descuento descuento);
}