package com.example.gym.gym_core_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gym.gym_core_service.model.Miembro;
import com.example.gym.gym_core_service.service.MiembroService;

@RestController
public class MiembroController {
    
    @Autowired
    private MiembroService miembroService;

    @GetMapping("/miembros")
    ResponseEntity<List<Miembro>> getAllMiembros() {
        List<Miembro> miembros = miembroService.getAllMiembros();
        if (miembros != null) {
            return ResponseEntity.ok(miembros);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
