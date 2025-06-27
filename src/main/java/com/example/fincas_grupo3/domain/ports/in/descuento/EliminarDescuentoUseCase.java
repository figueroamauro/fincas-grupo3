package com.example.fincas_grupo3.domain.ports.in.descuento;

import com.example.fincas_grupo3.domain.models.descuento.Descuento;

public interface EliminarDescuentoUseCase {
    Boolean eliminarDescuentoPorId(Long id);
}
