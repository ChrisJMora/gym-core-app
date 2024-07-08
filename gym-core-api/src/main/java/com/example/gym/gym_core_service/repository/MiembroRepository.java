package com.example.gym.gym_core_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gym.gym_core_service.model.Miembro;

public interface MiembroRepository extends JpaRepository<Miembro, Long>{
    
    List<Miembro> findAllByEntrenadorId(long id);
}
