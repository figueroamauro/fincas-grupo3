package com.example.fincas_grupo3.domain.ports.in.publicacion;

import com.example.fincas_grupo3.domain.models.publicacion.Publicacion;

public interface CrearPublicacionUseCase {


    Publicacion crearPublicacion(Publicacion publicacion);
}
