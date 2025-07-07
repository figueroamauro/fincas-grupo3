package com.example.fincas_grupo3.infrastructure.controllers.estadoPago;

import com.example.fincas_grupo3.application.dto.estadoPago.EstadoPagoRequestDTO;
import com.example.fincas_grupo3.application.dto.estadoPago.EstadoPagoResponseDTO;
import com.example.fincas_grupo3.application.services.estadoPago.EstadoPagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/estados-pago")
public class EstadoPagoController {

    private final EstadoPagoService estadoReservaService;

    public EstadoPagoController(EstadoPagoService estadoReservaService) {
        this.estadoReservaService = estadoReservaService;
    }

    @PostMapping
    public ResponseEntity<EstadoPagoResponseDTO> create(@RequestBody EstadoPagoRequestDTO requestDTO) {
        EstadoPagoResponseDTO responseDTO = estadoReservaService.crearEstadoPago(requestDTO);
        return ResponseEntity.created(URI.create("/api/estados-pago/" + responseDTO.getId())).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<EstadoPagoResponseDTO>> findAll() {
        return ResponseEntity.ok(estadoReservaService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoPagoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(estadoReservaService.obtenerPorId(id));
    }

    @PutMapping
    public ResponseEntity<EstadoPagoResponseDTO> update(@RequestBody EstadoPagoRequestDTO requestDTO) {
        return ResponseEntity.ok(estadoReservaService.actualizarEstadoPago(requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        estadoReservaService.eliminarEstadoPago(id);
        return ResponseEntity.noContent().build();
    }
}