package com.example.fincas_grupo3.infrastructure.repositories.rol;

import com.example.fincas_grupo3.infrastructure.entities.rol.RolEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPARolRepository extends JpaRepository<RolEntidad,Long> {
}
