package com.example.fincas_grupo3.infrastructure.repositories.tiporeserva;

import com.example.fincas_grupo3.infrastructure.entities.tiporeserva.TipoReservaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPATipoReservaRepository extends JpaRepository<TipoReservaEntidad, Long> {
}