package com.example.fincas_grupo3.infrastructure.repositories.direccion;

import com.example.fincas_grupo3.infrastructure.entities.direccion.DireccionEntidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPADireccionRepository extends JpaRepository<DireccionEntidad,Long> {

}
