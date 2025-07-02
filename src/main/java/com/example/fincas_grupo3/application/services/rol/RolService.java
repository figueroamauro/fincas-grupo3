package com.example.fincas_grupo3.application.services.rol;

import com.example.fincas_grupo3.application.dto.rol.RolResponseDTO;

import java.util.List;

public interface RolService {
    RolResponseDTO obtenerPorId(Long id);
    RolResponseDTO guardar(RolResponseDTO rolResponseDTO);
    Boolean eliminarPorId(Long id);
     List <RolResponseDTO> obtenerRoles();


}
