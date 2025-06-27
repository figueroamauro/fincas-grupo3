package com.example.fincas_grupo3.infrastructure.controllers.publicacion;

import com.example.fincas_grupo3.application.dto.publicacion.PublicacionRequestDTO;
import com.example.fincas_grupo3.application.dto.publicacion.PublicacionResponseDTO;
import com.example.fincas_grupo3.application.services.publicacion.PublicacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    private final PublicacionService publicacionService;

    public PublicacionController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @PostMapping
    public ResponseEntity<PublicacionResponseDTO> create(@RequestBody PublicacionRequestDTO dto) {
        PublicacionResponseDTO response = publicacionService.guardar(dto);
        return ResponseEntity.created(URI.create("/api/publicaciones/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PublicacionResponseDTO>> findAll() {
        List<PublicacionResponseDTO> response = publicacionService.obtenerTodas();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicacionResponseDTO> findById(@PathVariable Long id) {
        PublicacionResponseDTO response = publicacionService.obtenerPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<PublicacionResponseDTO> update(@RequestBody PublicacionRequestDTO dto) {
        PublicacionResponseDTO response = publicacionService.actualizar(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        publicacionService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
