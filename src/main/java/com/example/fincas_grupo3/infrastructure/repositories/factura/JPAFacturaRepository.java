package com.example.fincas_grupo3.infrastructure.repositories.factura;

import com.example.fincas_grupo3.infrastructure.entities.factura.FacturaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAFacturaRepository extends JpaRepository<FacturaEntidad, Long> {
}