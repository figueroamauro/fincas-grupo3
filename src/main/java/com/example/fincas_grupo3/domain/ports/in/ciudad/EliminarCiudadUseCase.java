package com.example.fincas_grupo3.domain.ports.in.ciudad;
import com.example.fincas_grupo3.domain.models.ciudad.Ciudad;

public interface EliminarCiudadUseCase {
    Boolean eliminarCiudad(Ciudad ciudad);
    Boolean eliminarCiudadPorId(Long id);


}
