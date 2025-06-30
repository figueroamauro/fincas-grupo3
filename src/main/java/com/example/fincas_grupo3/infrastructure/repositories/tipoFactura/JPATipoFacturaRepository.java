package com.example.fincas_grupo3.infrastructure.repositories.tipoFactura;

import com.example.fincas_grupo3.infrastructure.entities.tipoFactura.TipoFacturaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPATipoFacturaRepository extends JpaRepository<TipoFacturaEntidad, Long> {
}