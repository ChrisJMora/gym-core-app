package com.example.gym.gym_core_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.gym_core_service.model.Persona;
import com.example.gym.gym_core_service.repository.PersonaRepository;

@Service
public class PersonaService {
    
    @Autowired
    private PersonaRepository repository;

    public List<Persona> getAllPersonas() {
        return repository.findAll();
    }
}
