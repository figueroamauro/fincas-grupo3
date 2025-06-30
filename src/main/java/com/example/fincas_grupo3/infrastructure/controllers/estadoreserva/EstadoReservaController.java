package com.example.fincas_grupo3.infrastructure.controllers.estadoreserva;

import com.example.fincas_grupo3.application.dto.estadoreserva.EstadoReservaRequestDTO;
import com.example.fincas_grupo3.application.dto.estadoreserva.EstadoReservaResponseDTO;
import com.example.fincas_grupo3.application.services.estadoreserva.EstadoReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/estados-reserva")
public class EstadoReservaController {

    private final EstadoReservaService estadoReservaService;

    public EstadoReservaController(EstadoReservaService estadoReservaService) {
        this.estadoReservaService = estadoReservaService;
    }

    @PostMapping
    public ResponseEntity<EstadoReservaResponseDTO> create(@RequestBody EstadoReservaRequestDTO requestDTO) {
        EstadoReservaResponseDTO responseDTO = estadoReservaService.crearEstadoReserva(requestDTO);
        return ResponseEntity.created(URI.create("/api/estados-reserva/" + responseDTO.getId())).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<EstadoReservaResponseDTO>> findAll() {
        return ResponseEntity.ok(estadoReservaService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoReservaResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(estadoReservaService.obtenerPorId(id));
    }

    @PutMapping
    public ResponseEntity<EstadoReservaResponseDTO> update(@RequestBody EstadoReservaRequestDTO requestDTO) {
        return ResponseEntity.ok(estadoReservaService.actualizarEstadoReserva(requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        estadoReservaService.eliminarEstadoReserva(id);
        return ResponseEntity.noContent().build();
    }
}