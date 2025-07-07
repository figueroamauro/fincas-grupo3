package com.example.fincas_grupo3.infrastructure.repositories.estadoPago;

import com.example.fincas_grupo3.infrastructure.entities.estadoPago.EstadoPagoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAEstadoPagoRepository extends JpaRepository<EstadoPagoEntidad, Long> {
}