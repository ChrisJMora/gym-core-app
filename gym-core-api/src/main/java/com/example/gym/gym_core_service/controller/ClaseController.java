package com.example.gym.gym_core_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gym.gym_core_service.dto.ClaseDTO;
import com.example.gym.gym_core_service.service.ClaseService;

@RestController
public class ClaseController {
    
    @Autowired
    private ClaseService claseService;
    
    @GetMapping("/clases/entrenador")
    ResponseEntity<List<ClaseDTO>> getAllClasesByEntrenador(@RequestParam long id) {
        List<ClaseDTO> clases = claseService.getAllClasesByEntrenador(id);
        if (clases != null) {
            return ResponseEntity.ok(clases);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
