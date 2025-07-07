package com.example.fincas_grupo3.infrastructure.repositories.provincia;

import com.example.fincas_grupo3.infrastructure.entities.provincia.ProvinciaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAProvinciaRepository extends JpaRepository<ProvinciaEntidad,Long> {
}
