package com.example.fincas_grupo3.infrastructure.repositories.ciudad;

import com.example.fincas_grupo3.infrastructure.entities.ciudad.CiudadEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPACiudadRepository extends JpaRepository<CiudadEntidad,Long> {



}
