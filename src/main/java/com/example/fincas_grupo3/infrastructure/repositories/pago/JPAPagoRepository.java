package com.example.fincas_grupo3.infrastructure.repositories.pago;

import com.example.fincas_grupo3.infrastructure.entities.pago.PagoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAPagoRepository extends JpaRepository<PagoEntidad, Long> {
}