package com.example.Tarea.Controllers;

import com.example.Tarea.Models.SeguimientoModel;
import com.example.Tarea.Services.SeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/web/seguimientos")
public class SeguimientoController {

    @Autowired
    private SeguimientoService seguimientoService;

    @PostMapping
    public SeguimientoModel createSeguimiento(@RequestBody SeguimientoModel seguimiento) {
        return seguimientoService.saveSeguimiento(seguimiento);
    }

    @GetMapping
    public List<SeguimientoModel> getAllSeguimientos() {
        return seguimientoService.getAllSeguimientos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeguimientoModel> getSeguimientoById(@PathVariable Integer id) {
        return seguimientoService.getSeguimientoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeguimientoModel> updateSeguimiento(@PathVariable Integer id, @RequestBody SeguimientoModel seguimientoDetails) {
        return seguimientoService.getSeguimientoById(id)
                .map(seguimientoExistente -> {
                    // Actualiza los campos existentes
                    seguimientoExistente.setLatitud(seguimientoDetails.getLatitud());
                    seguimientoExistente.setLongitud(seguimientoDetails.getLongitud());
                    seguimientoExistente.setTimestamp(seguimientoDetails.getTimestamp());
                    seguimientoExistente.setRepartidor(seguimientoDetails.getRepartidor());
                    SeguimientoModel updatedSeguimiento = seguimientoService.saveSeguimiento(seguimientoExistente);
                    return ResponseEntity.ok(updatedSeguimiento);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeguimiento(@PathVariable Integer id) {
        if (seguimientoService.getSeguimientoById(id).isPresent()) {
            seguimientoService.deleteSeguimiento(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}