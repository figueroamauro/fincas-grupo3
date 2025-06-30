package com.example.fincas_grupo3.application.services.ciudad;

import com.example.fincas_grupo3.application.dto.ciudad.CiudadRequestDTO;
import com.example.fincas_grupo3.application.dto.ciudad.CiudadResponseDTO;

import java.util.List;

public interface CiudadService {

    CiudadResponseDTO crearCiudad(CiudadRequestDTO ciudad);

    CiudadResponseDTO actualizarCiudad(CiudadRequestDTO ciudad);

    List<CiudadResponseDTO> obtenerCiudades();

    CiudadResponseDTO obtenerCiudadPorId(Long id);

    Boolean eliminarCiudad(CiudadRequestDTO ciudad);

    Boolean eliminarCiudadPorId(Long id);
}
