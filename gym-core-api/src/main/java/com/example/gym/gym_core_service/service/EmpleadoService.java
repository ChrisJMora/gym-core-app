package com.example.gym.gym_core_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.gym_core_service.model.Cargo;
import com.example.gym.gym_core_service.model.Empleado;
import com.example.gym.gym_core_service.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
    
    @Autowired
    private EmpleadoRepository repository;

    public List<Empleado> getAllEmpleados() {
        return repository.findAll();
    }

    public List<Empleado> findByCargo(Cargo cargo) {
        return repository.findByCargo(cargo.getValue());
    }

    public Empleado getEmpleadoById(Long id) {
        Optional<Empleado> empleadoOpcional = repository.findById(id);
        if (empleadoOpcional.isPresent()) {
            return empleadoOpcional.get();
        } else {
            return null;
        }
    }

    public Empleado getEntrenadorById(Long id) {
        Optional<Empleado> empleado = repository
            .findByIdAndCargo(id, Cargo.ENTRENADOR.getValue());
        if (empleado.isPresent()) {
            return empleado.get();
        } else {
            return null;
        }
    }
}
