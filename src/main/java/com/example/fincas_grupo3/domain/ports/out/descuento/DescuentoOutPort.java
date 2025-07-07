package com.example.fincas_grupo3.domain.ports.out.descuento;



import com.example.fincas_grupo3.domain.models.descuento.Descuento;

import java.util.List;

public interface DescuentoOutPort {

    Descuento guardar(Descuento descuento);

    Descuento actualizar(Descuento descuento);

    List<Descuento> obtenerTodas();

    Descuento obtenerPorId(Long id);

    Boolean eliminarPorId(Long id);


}
