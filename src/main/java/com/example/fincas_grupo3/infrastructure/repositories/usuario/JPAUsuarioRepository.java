package com.example.fincas_grupo3.infrastructure.repositories.usuario;

import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import com.example.fincas_grupo3.infrastructure.entities.usuario.UsuarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAUsuarioRepository extends JpaRepository<UsuarioEntidad,Long> {

    UsuarioEntidad findByCorreo(String correo);



}
