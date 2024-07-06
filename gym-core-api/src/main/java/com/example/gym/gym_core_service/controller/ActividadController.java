package com.example.gym.gym_core_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.gym.gym_core_service.model.Actividad;
import com.example.gym.gym_core_service.service.ActividadService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ActividadController {
    
    @Autowired
    private ActividadService actividadService;
    
    @GetMapping("/actividades")
    ResponseEntity<List<Actividad>> getAllActividades() {
        List<Actividad> actividades = actividadService.getAllActividades();
        if (actividades != null) {
            return ResponseEntity.ok(actividades);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
