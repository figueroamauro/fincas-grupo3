package com.example.fincas_grupo3.application.mappers.finca;

import com.example.fincas_grupo3.application.dto.finca.FincaRequestDTO;
import com.example.fincas_grupo3.application.dto.finca.FincaResponseDTO;
import com.example.fincas_grupo3.application.dto.horario.HorarioDisponibleResponseDTO;
import com.example.fincas_grupo3.application.mappers.direccion.DireccionMapper;
import com.example.fincas_grupo3.application.mappers.horario.HorarioDisponibleMapper;
import com.example.fincas_grupo3.application.mappers.servicio.ServicioMapper;
import com.example.fincas_grupo3.application.mappers.tiporeserva.TipoReservaMapper;
import com.example.fincas_grupo3.application.mappers.usuario.UsuarioMapper;
import com.example.fincas_grupo3.application.usecases.horario.HorarioDisponibleUseCases;
import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.domain.models.horario.HorarioDisponible;
import com.example.fincas_grupo3.domain.models.servicio.Servicio;
import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Primary
@Mapper(componentModel = "spring",
        uses = {DireccionMapper.class, UsuarioMapper.class, ServicioMapper.class, HorarioDisponibleMapper.class, TipoReservaMapper.class})
public abstract class FincaMapper {
    @Autowired
    private HorarioDisponibleUseCases horarioDisponibleUseCases;
    @Autowired
    private HorarioDisponibleMapper horarioDisponibleMapper;

    @Mapping(source = "direccionId", target = "direccion.id")
    @Mapping(source = "usuarioId", target = "usuario.id")
    @Mapping(source = "servicioIds", target = "servicios")
    @Mapping(source = "tipoReservaIds", target = "tipoReservas", qualifiedByName = "mapTipoReservaIdsToTipoReserva")
    public abstract Finca toModel(FincaRequestDTO dto);

    protected Set<Servicio> mapServicioIdsToServicios(Set<Long> servicioIds) {
        if (servicioIds == null) {
            return Collections.emptySet();
        }
        return servicioIds.stream()
                .map(id -> {
                    Servicio servicio = new Servicio();
                    servicio.setId(id);
                    return servicio;
                })
                .collect(Collectors.toSet());
    }

    @Mapping(source = "horarioDisponibleList", target = "horarioDisponibleList", qualifiedByName = "mapToHorarioDisponibleList")
    public abstract FincaResponseDTO toDTO(Finca finca);

    @Named("mapToHorarioDisponibleList")
    public List<HorarioDisponibleResponseDTO> mapToHorarioDisponibleList(List<HorarioDisponible> list) {
       return list.stream().map(horarioDisponibleMapper::toDTO).toList();
    }

    @Named("mapTipoReservaIdsToTipoReserva")
    public Set<TipoReserva> mapTipoReservaIdsToTipoReserva(Set<Long> tipoReservaIds) {
        if (tipoReservaIds == null) {
            return Collections.emptySet();
        }
        return tipoReservaIds.stream()
                .map(id -> {
                    TipoReserva tipoReserva = new TipoReserva();
                    tipoReserva.setId(id);
                    return tipoReserva;
                }).collect(Collectors.toSet());
    }
}