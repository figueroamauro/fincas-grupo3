package com.example.fincas_grupo3.infrastructure.repositories.finca;

import com.example.fincas_grupo3.infrastructure.entities.finca.FincaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAFincaRepository extends JpaRepository<FincaEntidad,Long> {
}
