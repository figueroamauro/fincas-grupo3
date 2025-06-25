package com.example.fincas_grupo3.infrastructure.repositories;

import com.example.fincas_grupo3.infrastructure.entities.UsuarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAUsuarioRepository extends JpaRepository<UsuarioEntidad,Long> {



}
