package com.example.fincas_grupo3.application.mappers.tiporeserva;

import com.example.fincas_grupo3.application.dto.tiporeserva.TipoReservaRequestDTO;
import com.example.fincas_grupo3.application.dto.tiporeserva.TipoReservaResponseDTO;
import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "tipoReservaMapperApplication")
public abstract class TipoReservaMapper {
    public abstract TipoReserva toModel(TipoReservaRequestDTO requestDTO);
    public abstract TipoReservaResponseDTO toDTO(TipoReserva tipoReserva);
}