package com.example.fincas_grupo3.infrastructure.controllers.rol;

import com.example.fincas_grupo3.application.dto.rol.RolResponseDTO;
import com.example.fincas_grupo3.application.services.rol.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }
    @PostMapping
    public ResponseEntity<RolResponseDTO> create(@RequestBody RolResponseDTO dto) {
        RolResponseDTO response = rolService.guardar(dto);
        return ResponseEntity.created(URI.create("/api/roles/"+ response.getNombre())).body(response);
    }

 @GetMapping
    public ResponseEntity<List<RolResponseDTO>> findAll() {
        List<RolResponseDTO> response = rolService.obtenerRoles();
        return ResponseEntity.ok(response);
    }

@DeleteMapping
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        rolService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
}

    @GetMapping("/{id}")
    public ResponseEntity<RolResponseDTO> findById(@PathVariable Long id) {
        RolResponseDTO response = rolService.obtenerPorId(id);
        return ResponseEntity.ok(response);
}

}
