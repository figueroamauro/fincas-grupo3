package com.example.fincas_grupo3.infrastructure.repositories.estadopublicacion;

import com.example.fincas_grupo3.infrastructure.entities.estadopublicacion.EstadoPublicacionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAEstadoPublicacionRepository extends JpaRepository<EstadoPublicacionEntidad, Long> {
}