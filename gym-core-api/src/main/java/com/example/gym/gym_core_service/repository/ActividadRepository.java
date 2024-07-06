package com.example.gym.gym_core_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gym.gym_core_service.model.Actividad;

public interface ActividadRepository extends JpaRepository<Actividad, Long>{
    
}
