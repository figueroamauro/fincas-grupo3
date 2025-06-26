package com.example.fincas_grupo3.ciudades.application.services;

import com.example.fincas_grupo3.ciudades.application.dto.CiudadRequestDTO;
import com.example.fincas_grupo3.ciudades.application.dto.CiudadResponseDTO;

import java.util.List;

public interface CiudadService {

    CiudadResponseDTO crearCiudad(CiudadRequestDTO ciudad);

    CiudadResponseDTO actualizarCiudad(CiudadRequestDTO ciudad);

    List<CiudadResponseDTO> obtenerCiudades();

    CiudadResponseDTO obtenerCiudadPorId(Long id);

    Boolean eliminarCiudad(CiudadRequestDTO ciudad);

    Boolean eliminarCiudadPorId(Long id);
}
