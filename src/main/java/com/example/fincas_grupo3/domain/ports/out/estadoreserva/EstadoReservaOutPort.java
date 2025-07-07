package com.example.fincas_grupo3.domain.ports.out.estadoreserva;

import com.example.fincas_grupo3.domain.models.estadoreserva.EstadoReserva;
import java.util.List;

public interface EstadoReservaOutPort {
    EstadoReserva save(EstadoReserva estadoReserva);
    EstadoReserva findById(Long id);
    List<EstadoReserva> findAll();
    EstadoReserva update(EstadoReserva estadoReserva);
    boolean deleteById(Long id);
}