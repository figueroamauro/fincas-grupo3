package com.example.fincas_grupo3.infrastructure.controllers.ciudad;

import com.example.fincas_grupo3.application.dto.ciudad.CiudadRequestDTO;
import com.example.fincas_grupo3.application.dto.ciudad.CiudadResponseDTO;
import com.example.fincas_grupo3.application.services.ciudad.CiudadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {

    private final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @PostMapping
    public ResponseEntity<CiudadResponseDTO> create(@RequestBody CiudadRequestDTO dto) {
        CiudadResponseDTO response = ciudadService.crearCiudad(dto);
        return ResponseEntity.created(URI.create("/api/ciudades/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CiudadResponseDTO>> findAll() {
        return ResponseEntity.ok(ciudadService.obtenerCiudades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CiudadResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ciudadService.obtenerCiudadPorId(id));
    }

    @PutMapping
    public ResponseEntity<CiudadResponseDTO> update(@RequestBody CiudadRequestDTO dto) {
        return ResponseEntity.ok(ciudadService.actualizarCiudad(dto));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody CiudadRequestDTO dto) {
        ciudadService.eliminarCiudad(dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        ciudadService.eliminarCiudadPorId(id);
        return ResponseEntity.noContent().build();
    }
}
