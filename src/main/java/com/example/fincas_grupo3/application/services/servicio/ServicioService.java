package com.example.fincas_grupo3.application.services.servicio;

import com.example.fincas_grupo3.application.dto.servicio.ServicioRequestDTO;
import com.example.fincas_grupo3.application.dto.servicio.ServicioResponseDTO;

import java.util.List;

public interface ServicioService  {

        ServicioResponseDTO crearServicio(ServicioRequestDTO servicio);

        ServicioResponseDTO actualizarServicio(ServicioRequestDTO servicio);

        List<ServicioResponseDTO> obtenerServicios();

        ServicioResponseDTO obtenerServicioPorId(Long id);

        Boolean eliminarServicioPorId(Long id);

}