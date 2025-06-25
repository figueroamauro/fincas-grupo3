package com.example.fincas_grupo3.domain.ports.in.usuario;

import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface EliminarUsuarioUseCase {
    Boolean eliminarUsuario(Usuario usuario);
    Boolean eliminarUsuarioPorId(Long id);

}
