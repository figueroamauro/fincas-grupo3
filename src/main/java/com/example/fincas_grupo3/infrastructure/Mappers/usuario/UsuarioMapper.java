    package com.example.fincas_grupo3.infrastructure.Mappers.usuario;


    import com.example.fincas_grupo3.domain.models.usuario.Usuario;
    import com.example.fincas_grupo3.infrastructure.entities.usuario.UsuarioEntidad;
    import org.mapstruct.Mapper;

    @Mapper(componentModel = "spring",implementationName = "usuarioMapperInfra")
    public abstract class UsuarioMapper {

        public abstract Usuario toModel(UsuarioEntidad entidad);

        public abstract UsuarioEntidad toEntity(Usuario usuario);

    }
