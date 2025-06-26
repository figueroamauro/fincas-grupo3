    package com.example.fincas_grupo3.infrastructure.adapters.servicio;

    import com.example.fincas_grupo3.infrastructure.Mappers.servicio.ServicioMapper;
    import com.example.fincas_grupo3.domain.models.servicio.Servicio;
    import com.example.fincas_grupo3.domain.ports.out.servicio.ServicioOutPort;
    import com.example.fincas_grupo3.infrastructure.entities.servicio.ServicioEntidad;
    import com.example.fincas_grupo3.infrastructure.repositories.servicio.JPAServicioRepository;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class ServicioAdapter implements ServicioOutPort {

        private final JPAServicioRepository jpaServicioRepository;
        private final ServicioMapper servicioMapperInfra;

        public ServicioAdapter(JPAServicioRepository jpaServicioRepository, ServicioMapper servicioMapperInfra) {
            this.jpaServicioRepository = jpaServicioRepository;
            this.servicioMapperInfra = servicioMapperInfra;
        }

        @Override
        public Servicio guardar(Servicio servicio) {
            ServicioEntidad entidad = servicioMapperInfra.toEntity(servicio);
            ServicioEntidad entidadGuardada = jpaServicioRepository.save(entidad);
            return servicioMapperInfra.toModel(entidadGuardada);
        }

        @Override
        public Servicio actualizarServicio(Servicio servicio) {
            ServicioEntidad entidad = servicioMapperInfra.toEntity(servicio);
            ServicioEntidad entidadActualizada = jpaServicioRepository.save(entidad);
            return servicioMapperInfra.toModel(entidadActualizada);
        }

        @Override
        public List<Servicio> obtenerTodas() {
            return jpaServicioRepository.findAll().stream()
                    .map(servicioMapperInfra::toModel)
                    .toList();
        }

        @Override
        public Servicio obtenerServicioPorId(Long id) {
            Optional<ServicioEntidad> servicioEncontrado = jpaServicioRepository.findById(id);
            return servicioEncontrado.map(servicioMapperInfra::toModel).orElse(null);
        }

        @Override
        public boolean eliminarServicioPorId(Long id) {
            Optional<ServicioEntidad> servicioEncontrado = jpaServicioRepository.findById(id);
            if (servicioEncontrado.isPresent()) {
                jpaServicioRepository.deleteById(id);
                return true;
            }
            return false;
        }
    }