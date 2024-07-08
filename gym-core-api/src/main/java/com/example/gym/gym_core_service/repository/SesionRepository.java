package com.example.gym.gym_core_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gym.gym_core_service.model.Sesion;

public interface SesionRepository extends JpaRepository<Sesion, Long> {
    
    List<Sesion> findByMiembroId(long id);
}
