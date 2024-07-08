package com.example.gym.gym_core_service.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.example.gym.gym_core_service.dto.SesionDTO;
import com.example.gym.gym_core_service.model.Empleado;
import com.example.gym.gym_core_service.model.Evento;
import com.example.gym.gym_core_service.model.Miembro;
import com.example.gym.gym_core_service.model.Persona;
import com.example.gym.gym_core_service.model.Sesion;

public class SesionUtil {
    
    public static SesionDTO convertToDTO(Sesion sesion) {
        SesionDTO dto = new SesionDTO();
        Miembro miembro = sesion.getMiembro();
        Empleado entrenador = miembro.getEntrenador();
        Persona persona = entrenador.getInformacionPersonal();
        Evento evento = sesion.getEvento();
        dto.setEntrenador(persona.getNombres() + " " + persona.getApellidos());
        dto.setDia(evento.getDia());
        dto.setHoraInicio(evento.getHoraInicio());
        dto.setHoraFin(evento.getHoraFin());
        return dto;
    }

    public static List<SesionDTO> convertToDTO(List<Sesion> sesiones) {
        return sesiones.stream().map(SesionUtil::convertToDTO).collect(Collectors.toList());
    }
}
