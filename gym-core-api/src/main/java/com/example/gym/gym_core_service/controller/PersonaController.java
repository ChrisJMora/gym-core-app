package com.example.gym.gym_core_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gym.gym_core_service.dto.PersonaDTO;
import com.example.gym.gym_core_service.service.PersonaService;

@RestController
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/personas")
    ResponseEntity<List<PersonaDTO>> getAllPersonas() {
        List<PersonaDTO> personas = personaService.getAllPersonas();
        if (personas != null) {
            return ResponseEntity.ok(personas);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
