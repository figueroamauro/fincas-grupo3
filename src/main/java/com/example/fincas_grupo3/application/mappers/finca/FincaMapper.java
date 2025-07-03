package com.example.fincas_grupo3.application.mappers.finca;

import com.example.fincas_grupo3.application.dto.finca.FincaRequestDTO;
import com.example.fincas_grupo3.application.dto.finca.FincaResponseDTO;
import com.example.fincas_grupo3.application.mappers.direccion.DireccionMapper;
import com.example.fincas_grupo3.application.mappers.servicio.ServicioMapper;
import com.example.fincas_grupo3.application.mappers.usuario.UsuarioMapper;
import com.example.fincas_grupo3.domain.models.finca.Finca;
import com.example.fincas_grupo3.domain.models.servicio.Servicio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Primary;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Primary
@Mapper(componentModel = "spring",
        uses = {DireccionMapper.class, UsuarioMapper.class, ServicioMapper.class})
public abstract class FincaMapper {

    @Mapping(source = "direccionId", target = "direccion.id")
    @Mapping(source = "usuarioId", target = "usuario.id")
    @Mapping(source = "servicioIds", target = "servicios")
    public abstract Finca toModel(FincaRequestDTO dto);

    protected List<Servicio> mapServicioIdsToServicios(List<Long> servicioIds) {
        if (servicioIds == null) {
            return Collections.emptyList();
        }
        return servicioIds.stream()
                .map(id -> {
                    Servicio servicio = new Servicio();
                    servicio.setId(id);
                    return servicio;
                })
                .collect(Collectors.toList());
    }

    public abstract FincaResponseDTO toDTO(Finca finca);
}