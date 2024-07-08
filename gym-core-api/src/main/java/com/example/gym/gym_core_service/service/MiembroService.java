package com.example.gym.gym_core_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.gym_core_service.dto.MiembroDTO;
import com.example.gym.gym_core_service.model.Miembro;
import com.example.gym.gym_core_service.repository.MiembroRepository;
import com.example.gym.gym_core_service.utils.MiembroUtil;

@Service
public class MiembroService {
    
    @Autowired
    private MiembroRepository repository;

    public List<MiembroDTO> getAllMiembros() {
        List<Miembro> miembros = repository.findAll();
        return MiembroUtil.convertToDTO(miembros);
    }

    public List<MiembroDTO> getAllMiembrosByEntrenadorId(long id) {
        List<Miembro> miembros = repository.findAllByEntrenadorId(id);
        return MiembroUtil.convertToDTO(miembros);
    }
}
