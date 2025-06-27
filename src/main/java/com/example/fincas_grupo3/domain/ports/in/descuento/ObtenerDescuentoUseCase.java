package com.example.fincas_grupo3.domain.ports.in.descuento;



import com.example.fincas_grupo3.domain.models.descuento.Descuento;

import java.util.List;

public interface ObtenerDescuentoUseCase {
    List<Descuento> obtenerDescuentos();


    Descuento obtenerDescuentoPorId(Long id);
}
