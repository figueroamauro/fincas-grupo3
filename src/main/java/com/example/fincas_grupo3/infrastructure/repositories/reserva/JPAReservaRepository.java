package com.example.fincas_grupo3.infrastructure.repositories.reserva;

import com.example.fincas_grupo3.infrastructure.entities.reserva.ReservaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAReservaRepository extends JpaRepository<ReservaEntidad, Long> {
}