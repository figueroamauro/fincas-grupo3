package com.example.fincas_grupo3.domain.ports.out.servicio;

import com.example.fincas_grupo3.domain.models.servicio.Servicio;

import java.util.List;

public interface ServicioOutPort {

  Servicio guardar(Servicio servicio);

  boolean eliminarServicioPorId(Long id);

  Servicio obtenerServicioPorId(Long id);

  List<Servicio> obtenerTodas();

  Servicio actualizarServicio(Servicio servicio);


}
