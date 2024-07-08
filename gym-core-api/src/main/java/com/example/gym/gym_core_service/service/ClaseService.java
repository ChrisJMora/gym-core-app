package com.example.gym.gym_core_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.gym_core_service.model.Clase;
import com.example.gym.gym_core_service.repository.ClaseRepository;

@Service
public class ClaseService {
    
    @Autowired
    private ClaseRepository repository;

    public List<Clase> getAllClasesByEntrenador(long id) {
        return repository.findByEntrenadorId(id);
    }
}
