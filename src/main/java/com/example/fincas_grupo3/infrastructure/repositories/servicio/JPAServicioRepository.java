package com.example.fincas_grupo3.infrastructure.repositories.servicio;


import com.example.fincas_grupo3.infrastructure.entities.servicio.ServicioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAServicioRepository extends JpaRepository<ServicioEntidad,Long> {
}
