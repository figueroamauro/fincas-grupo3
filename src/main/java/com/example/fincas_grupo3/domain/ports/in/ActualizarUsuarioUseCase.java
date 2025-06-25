package com.example.fincas_grupo3.domain.ports.in;

import com.example.fincas_grupo3.domain.models.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface ActualizarUsuarioUseCase {
    Usuario actualizarUsuario(Usuario usuario);

}
