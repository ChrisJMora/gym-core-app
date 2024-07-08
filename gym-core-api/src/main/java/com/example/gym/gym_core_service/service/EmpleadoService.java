package com.example.gym.gym_core_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.gym_core_service.dto.EmpleadoDTO;
import com.example.gym.gym_core_service.model.Cargo;
import com.example.gym.gym_core_service.model.Empleado;
import com.example.gym.gym_core_service.repository.EmpleadoRepository;
import com.example.gym.gym_core_service.utils.EmpleadoUtil;

@Service
public class EmpleadoService {
    
    @Autowired
    private EmpleadoRepository repository;

    public List<EmpleadoDTO> getAllEmpleados() {
        List<Empleado> empleados = repository.findAll();
        return EmpleadoUtil.convertToDTO(empleados);
    }

    public List<EmpleadoDTO> findByCargo(Cargo cargo) {
        List<Empleado> empleados = repository.findByCargo(cargo.getValue());
        return EmpleadoUtil.convertToDTO(empleados);
    }

    public EmpleadoDTO getEmpleadoById(Long id) {
        Optional<Empleado> empleadoOpcional = repository.findById(id);
        if (empleadoOpcional.isPresent()) {
            return EmpleadoUtil.convertToDTO(empleadoOpcional.get());
        } else {
            return null;
        }
    }

    public EmpleadoDTO getEntrenadorById(Long id) {
        Optional<Empleado> empleado = repository
            .findByIdAndCargo(id, Cargo.ENTRENADOR.getValue());
        if (empleado.isPresent()) {
            return EmpleadoUtil.convertToDTO(empleado.get());
        } else {
            return null;
        }
    }
}
