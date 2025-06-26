package com.example.fincas_grupo3.ciudades.domain.ports.in;
import com.example.fincas_grupo3.ciudades.domain.models.Ciudad;

public interface EliminarCiudadUseCase {
    Boolean eliminarCiudad(Ciudad ciudad);
    Boolean eliminarCiudadPorId(Long id);


}
