package com.example.gym.gym_core_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.gym.gym_core_service.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{
    
    @Query("SELECT e FROM Evento e ORDER BY e.dia, e.horaInicio")
    List<Evento> findAllOrderByDiaAndHoraInicio();
}
