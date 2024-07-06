package com.example.gym.gym_core_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.gym_core_service.model.Actividad;
import com.example.gym.gym_core_service.repository.ActividadRepository;

@Service
public class ActividadService {
    
    @Autowired
    private ActividadRepository repository;

    public List<Actividad> getAllActividades() {
        return repository.findAll();
    }
}
