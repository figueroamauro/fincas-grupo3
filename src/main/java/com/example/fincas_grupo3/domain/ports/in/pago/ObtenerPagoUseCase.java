package com.example.fincas_grupo3.domain.ports.in.pago;

import com.example.fincas_grupo3.domain.models.pago.Pago;
import java.util.List;

public interface ObtenerPagoUseCase {
    Pago obtenerPagoPorId(Long id);
    List<Pago> obtenerTodosLosPagos();
}