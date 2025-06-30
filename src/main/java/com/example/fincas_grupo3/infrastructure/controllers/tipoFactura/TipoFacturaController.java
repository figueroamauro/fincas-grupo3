package com.example.fincas_grupo3.infrastructure.controllers.tipoFactura;

import com.example.fincas_grupo3.application.dto.tipoFactura.TipoFacturaRequestDTO;
import com.example.fincas_grupo3.application.dto.tipoFactura.TipoFacturaResponseDTO;
import com.example.fincas_grupo3.application.services.tipoFactura.TipoFacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-factura")
public class TipoFacturaController {

    private final TipoFacturaService tipoFacturaService;

    public TipoFacturaController(TipoFacturaService tipoFacturaService) {
        this.tipoFacturaService = tipoFacturaService;
    }

    @PostMapping
    public ResponseEntity<TipoFacturaResponseDTO> create(@RequestBody TipoFacturaRequestDTO requestDTO) {
        TipoFacturaResponseDTO responseDTO = tipoFacturaService.crearTipoFactura(requestDTO);
        return ResponseEntity.created(URI.create("/api/tipos-factura/" + responseDTO.getId())).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<TipoFacturaResponseDTO>> findAll() {
        return ResponseEntity.ok(tipoFacturaService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoFacturaResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(tipoFacturaService.obtenerPorId(id));
    }

    @PutMapping
    public ResponseEntity<TipoFacturaResponseDTO> update(@RequestBody TipoFacturaRequestDTO requestDTO) {
        return ResponseEntity.ok(tipoFacturaService.actualizarTipoFactura(requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tipoFacturaService.eliminarTipoFactura(id);
        return ResponseEntity.noContent().build();
    }
}