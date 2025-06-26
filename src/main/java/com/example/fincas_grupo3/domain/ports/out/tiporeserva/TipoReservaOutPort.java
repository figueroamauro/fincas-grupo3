package com.example.fincas_grupo3.domain.ports.out.tiporeserva;

import com.example.fincas_grupo3.domain.models.tiporeserva.TipoReserva;
import java.util.List;

public interface TipoReservaOutPort {
    TipoReserva save(TipoReserva tipoReserva);
    TipoReserva findById(Long id);
    List<TipoReserva> findAll();
    TipoReserva update(TipoReserva tipoReserva);
    boolean deleteById(Long id);
}