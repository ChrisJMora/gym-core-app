package com.example.gym.gym_core_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.gym_core_service.dto.SesionDTO;
import com.example.gym.gym_core_service.model.Sesion;
import com.example.gym.gym_core_service.repository.SesionRepository;
import com.example.gym.gym_core_service.utils.SesionUtil;

@Service
public class SesionService {
    
    @Autowired
    private SesionRepository repository;

    public List<SesionDTO> getAllSesionesByMiembro(long id) {
        List<Sesion> sesiones = repository.findByMiembroId(id);
        return SesionUtil.convertToDTO(sesiones);
    }
}
