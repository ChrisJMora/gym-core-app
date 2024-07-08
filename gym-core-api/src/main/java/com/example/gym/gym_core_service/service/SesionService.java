package com.example.gym.gym_core_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.gym_core_service.model.Sesion;
import com.example.gym.gym_core_service.repository.SesionRepository;

@Service
public class SesionService {
    
    @Autowired
    private SesionRepository repository;

    public List<Sesion> getAllSesionesByMiembro(long id) {
        return repository.findByMiembroId(id);
    }
}
