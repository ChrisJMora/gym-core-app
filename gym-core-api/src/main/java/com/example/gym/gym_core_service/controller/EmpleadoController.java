package com.example.gym.gym_core_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gym.gym_core_service.model.Cargo;
import com.example.gym.gym_core_service.model.Empleado;
import com.example.gym.gym_core_service.service.EmpleadoService;

@RestController
public class EmpleadoController {
    
    @Autowired
    private EmpleadoService empleadoService;
    
    @GetMapping("/empleados")
    ResponseEntity<List<Empleado>> getAllEmpleados() {
        List<Empleado> empleados = empleadoService.getAllEmpleados();
        if (empleados != null) {
            return ResponseEntity.ok(empleados);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/entrenadores")
    ResponseEntity<List<Empleado>> getAllEntrenadores() {
        List<Empleado> entrenadores = empleadoService.findByCargo(Cargo.ENTRENADOR);
        if (entrenadores != null) {
            return ResponseEntity.ok(entrenadores);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/empleado")
    ResponseEntity<Empleado> getEmpleadoById(@RequestParam Long id) {
        Empleado empleado = empleadoService.getEmpleadoById(id);
        if (empleado != null) {
            return ResponseEntity.ok(empleado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/entrenador")
    ResponseEntity<Empleado> getEntrenadorById(@RequestParam Long id) {
        Empleado empleado = empleadoService.getEntrenadorById(id);
        if (empleado != null) {
            return ResponseEntity.ok(empleado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
