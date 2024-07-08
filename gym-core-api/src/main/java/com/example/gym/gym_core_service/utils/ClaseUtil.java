package com.example.gym.gym_core_service.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.example.gym.gym_core_service.dto.ClaseDTO;
import com.example.gym.gym_core_service.model.Actividad;
import com.example.gym.gym_core_service.model.Clase;
import com.example.gym.gym_core_service.model.Evento;

public class ClaseUtil {
    
    public static ClaseDTO convertToDTO(Clase clase) {
        ClaseDTO dto = new ClaseDTO();
        Actividad actividad = clase.getActividad();
        Evento evento = clase.getEvento();
        dto.setActividad(actividad.getNombre());
        dto.setDescripcion(actividad.getDescripcion());
        dto.setDia(evento.getDia());
        dto.setHoraInicio(evento.getHoraInicio());
        dto.setHoraFin(evento.getHoraFin());
        return dto;
    }

    public static List<ClaseDTO> convertToDTO(List<Clase> clases) {
        return clases.stream().map(ClaseUtil::convertToDTO).collect(Collectors.toList());
    }
}
