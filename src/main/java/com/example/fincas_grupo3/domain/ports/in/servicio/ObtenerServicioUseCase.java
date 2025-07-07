package com.example.fincas_grupo3.domain.ports.in.servicio;


import com.example.fincas_grupo3.domain.models.servicio.Servicio;

import java.util.List;

public interface ObtenerServicioUseCase {
    List<Servicio> obtenerServicios();


    Servicio obtenerServicioPorId(Long id);

}