package com.example.gym.gym_core_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.gym_core_service.model.Evento;
import com.example.gym.gym_core_service.repository.EventoRepository;

@Service
public class EventoService {
    
    @Autowired
    private EventoRepository repository;

    public List<Evento> getAllEventos() {
        return repository.findAllOrderByDiaAndHoraInicio();
    }
}
