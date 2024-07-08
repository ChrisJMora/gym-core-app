package com.example.gym.gym_core_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gym.gym_core_service.dto.MiembroDTO;
import com.example.gym.gym_core_service.dto.PutMiembroDTO;
import com.example.gym.gym_core_service.service.KafkaProvider;
import com.example.gym.gym_core_service.service.MiembroService;

@RestController
public class MiembroController {
    
    @Autowired
    private MiembroService miembroService;

    @Autowired
    private KafkaProvider kafkaProvider;

    @GetMapping("/miembros")
    ResponseEntity<List<MiembroDTO>> getAllMiembros() {
        List<MiembroDTO> miembros = miembroService.getAllMiembros();
        if (miembros != null) {
            return ResponseEntity.ok(miembros);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/miembros/entrenador")
    ResponseEntity<List<MiembroDTO>> getAllMiembrosByEntrenadorId(@RequestParam long id) {
        List<MiembroDTO> miembros = miembroService.getAllMiembrosByEntrenadorId(id);
        if (miembros != null) {
            return ResponseEntity.ok(miembros);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/miembro")
    ResponseEntity<MiembroDTO> updateMiembro(@RequestParam long id, @RequestBody PutMiembroDTO miembro) {
        MiembroDTO miembro_actualizado = miembroService.updateMiembro(id, miembro);
        if (miembro_actualizado != null) {
            kafkaProvider.sendMiembro(miembro_actualizado);
            return ResponseEntity.ok(miembro_actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
