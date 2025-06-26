package com.example.fincas_grupo3.ciudades.infrastructure.repositories;

import com.example.fincas_grupo3.ciudades.infrastructure.entities.CiudadEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPACiudadRepository extends JpaRepository<CiudadEntidad,Long> {



}
