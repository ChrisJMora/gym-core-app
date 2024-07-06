package com.example.gym.gym_core_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gym.gym_core_service.model.Empleado;

import java.util.List;
import java.util.Optional;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
    List<Empleado> findByCargo(String cargo);
    Optional<Empleado> findByIdAndCargo(Long id, String cargo);
}
