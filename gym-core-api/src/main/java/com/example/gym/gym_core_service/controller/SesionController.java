package com.example.gym.gym_core_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gym.gym_core_service.dto.SesionDTO;
import com.example.gym.gym_core_service.service.SesionService;

@RestController
public class SesionController {
    
    @Autowired
    private SesionService sesionService;

    @GetMapping("/sesiones/miembro")
    ResponseEntity<List<SesionDTO>> getAllSesionesByMiembro(@RequestParam long id) {
        List<SesionDTO> sesiones = sesionService.getAllSesionesByMiembro(id);
        if (sesiones != null) {
            return ResponseEntity.ok(sesiones);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
