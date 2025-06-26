package com.example.fincas_grupo3.infrastructure.controllers.factura;

import com.example.fincas_grupo3.application.dto.factura.FacturaRequestDTO;
import com.example.fincas_grupo3.application.dto.factura.FacturaResponseDTO;
import com.example.fincas_grupo3.application.services.factura.FacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @PostMapping
    public ResponseEntity<FacturaResponseDTO> create(@RequestBody FacturaRequestDTO requestDTO) {
        FacturaResponseDTO responseDTO = facturaService.crearFactura(requestDTO);
        return ResponseEntity.created(URI.create("/api/facturas/" + responseDTO.getId())).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<FacturaResponseDTO>> findAll() {
        return ResponseEntity.ok(facturaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(facturaService.obtenerPorId(id));
    }

    @PutMapping
    public ResponseEntity<FacturaResponseDTO> update(@RequestBody FacturaRequestDTO requestDTO) {
        return ResponseEntity.ok(facturaService.actualizarFactura(requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        facturaService.eliminarFactura(id);
        return ResponseEntity.noContent().build();
    }
}