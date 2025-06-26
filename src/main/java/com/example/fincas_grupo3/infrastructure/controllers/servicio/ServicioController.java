package com.example.fincas_grupo3.infrastructure.controllers.servicio;


import com.example.fincas_grupo3.application.dto.servicio.ServicioRequestDTO;
import com.example.fincas_grupo3.application.dto.servicio.ServicioResponseDTO;
import com.example.fincas_grupo3.application.services.servicio.ServicioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @PostMapping
    public ResponseEntity<ServicioResponseDTO> create(@RequestBody ServicioRequestDTO dto) {
        ServicioResponseDTO response = servicioService.crearServicio(dto);
        return ResponseEntity.created(URI.create("/api/servicios/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ServicioResponseDTO>> findAll() {
        List<ServicioResponseDTO> response = servicioService.obtenerServicios();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioResponseDTO> findById(@PathVariable Long id) {
        ServicioResponseDTO response = servicioService.obtenerServicioPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<ServicioResponseDTO> update(@RequestBody ServicioRequestDTO dto) {
        ServicioResponseDTO response = servicioService.actualizarServicio(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        servicioService.eliminarServicioPorId(id);
        return ResponseEntity.noContent().build();
    }
}