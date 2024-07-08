package com.example.gym.gym_core_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gym.gym_core_service.model.Evento;
import com.example.gym.gym_core_service.service.EventoService;

@RestController
public class EventoController {
    
    @Autowired
    private EventoService eventoService;

    @GetMapping("/eventos")
    ResponseEntity<List<Evento>> getAllEventos() {
        List<Evento> eventos = eventoService.getAllEventos();
        if (eventos != null) {
            return ResponseEntity.ok(eventos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
