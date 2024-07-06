package com.example.gym.gym_core_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.gym_core_service.model.Miembro;
import com.example.gym.gym_core_service.repository.MiembroRepository;

@Service
public class MiembroService {
    
    @Autowired
    private MiembroRepository repository;

    public List<Miembro> getAllMiembros() {
        return repository.findAll();
    }
}
