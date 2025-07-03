package com.example.fincas_grupo3.infrastructure.mappers.horario;

import com.example.fincas_grupo3.domain.models.horario.HorarioDisponible;
import com.example.fincas_grupo3.infrastructure.entities.horario.HorarioDisponibleEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "horarioMapperInfra")
public abstract class HorarioDisponibleMapper {

    public abstract HorarioDisponible toModel(HorarioDisponibleEntidad entidad);

    public abstract HorarioDisponibleEntidad toEntidad(HorarioDisponible modelo);
}
