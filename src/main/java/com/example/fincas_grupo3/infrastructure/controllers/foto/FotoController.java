package com.example.fincas_grupo3.infrastructure.controllers.foto;

import com.example.fincas_grupo3.application.dto.foto.FotoRequestDTO;
import com.example.fincas_grupo3.application.dto.foto.FotoResponseDTO;
import com.example.fincas_grupo3.application.services.foto.FotoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/fotos")
public class FotoController {
    private final FotoService fotoService;

    public FotoController(FotoService fotoService) {
        this.fotoService = fotoService;
    }

    @PostMapping
    public ResponseEntity<FotoResponseDTO> create(@RequestBody FotoRequestDTO dto) {
        FotoResponseDTO response = fotoService.guardar(dto);
        return ResponseEntity.created(URI.create("/api/fotos/" + dto.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<FotoResponseDTO>> findAll() {
        List<FotoResponseDTO> response = fotoService.obtenerTodas();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FotoResponseDTO> findById(@PathVariable Long id) {
        FotoResponseDTO response = fotoService.obtenerPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<FotoResponseDTO> update(@RequestBody FotoRequestDTO dto) {
        FotoResponseDTO response = fotoService.actualizar(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FotoResponseDTO> delete(@PathVariable Long id) {
        fotoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
