package com.example.gym.gym_core_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.gym_core_service.dto.ClaseDTO;
import com.example.gym.gym_core_service.model.Clase;
import com.example.gym.gym_core_service.repository.ClaseRepository;
import com.example.gym.gym_core_service.utils.ClaseUtil;

@Service
public class ClaseService {
    
    @Autowired
    private ClaseRepository repository;

    public List<ClaseDTO> getAllClasesByEntrenador(long id) {
        List<Clase> clases = repository.findByEntrenadorId(id);
        return ClaseUtil.convertToDTO(clases);
    }
}
