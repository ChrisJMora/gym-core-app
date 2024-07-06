package com.example.gym.gym_core_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gym.gym_core_service.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
}
