package com.example.gym.gym_core_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.gym_core_service.dto.PersonaDTO;
import com.example.gym.gym_core_service.model.Persona;
import com.example.gym.gym_core_service.repository.PersonaRepository;
import com.example.gym.gym_core_service.utils.PersonaUtil;

@Service
public class PersonaService {
    
    @Autowired
    private PersonaRepository repository;

    public List<PersonaDTO> getAllPersonas() {
        List<Persona> personas = repository.findAll();
        return PersonaUtil.convertToDTO(personas);
    }
}
