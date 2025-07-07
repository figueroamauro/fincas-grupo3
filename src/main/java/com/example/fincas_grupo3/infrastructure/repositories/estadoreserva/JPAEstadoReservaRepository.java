package com.example.fincas_grupo3.infrastructure.repositories.estadoreserva;

import com.example.fincas_grupo3.infrastructure.entities.estadoreserva.EstadoReservaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAEstadoReservaRepository extends JpaRepository<EstadoReservaEntidad, Long> {
}