package com.example.fincas_grupo3.application.mappers.horario;

import com.example.fincas_grupo3.application.dto.horario.HorarioDisponibleRequestDTO;
import com.example.fincas_grupo3.application.dto.horario.HorarioDisponibleResponseDTO;
import com.example.fincas_grupo3.domain.models.horario.HorarioDisponible;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "horarioMapperApplication")
public abstract class HorarioDisponibleMapper {

    public abstract HorarioDisponible toModel(HorarioDisponibleRequestDTO dto);

    public abstract HorarioDisponibleResponseDTO toDTO(HorarioDisponible horarioDisponible);
}
