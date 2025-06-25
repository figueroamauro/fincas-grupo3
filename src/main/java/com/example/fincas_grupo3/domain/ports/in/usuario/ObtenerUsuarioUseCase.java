package com.example.fincas_grupo3.domain.ports.in.usuario;

import com.example.fincas_grupo3.domain.models.usuario.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ObtenerUsuarioUseCase {
    List<Usuario> obtenerUsuarios();

    Usuario obtenerUsuarioPorId(Long id);

}
