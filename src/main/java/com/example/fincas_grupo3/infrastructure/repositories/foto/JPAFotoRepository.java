package com.example.fincas_grupo3.infrastructure.repositories.foto;

import com.example.fincas_grupo3.infrastructure.entities.foto.FotoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAFotoRepository extends JpaRepository<FotoEntidad, Long> {
}
