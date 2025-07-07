package com.example.fincas_grupo3.infrastructure.repositories.publicacion;

import com.example.fincas_grupo3.infrastructure.entities.publicacion.PublicacionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAPublicacionRepository extends JpaRepository<PublicacionEntidad, Long> {
}