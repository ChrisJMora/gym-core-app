package com.example.gym.gym_core_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gym.gym_core_service.model.Clase;

public interface ClaseRepository extends JpaRepository<Clase, Long> {
    
    List<Clase> findByEntrenadorId(long id);
}
