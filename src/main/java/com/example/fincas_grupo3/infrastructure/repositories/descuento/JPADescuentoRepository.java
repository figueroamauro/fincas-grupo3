package com.example.fincas_grupo3.infrastructure.repositories.descuento;

import com.example.fincas_grupo3.infrastructure.entities.descuento.DescuentoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPADescuentoRepository extends JpaRepository<DescuentoEntidad,Long> {
}
