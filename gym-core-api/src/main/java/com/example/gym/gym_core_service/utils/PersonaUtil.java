package com.example.gym.gym_core_service.utils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import com.example.gym.gym_core_service.dto.PersonaDTO;
import com.example.gym.gym_core_service.model.Persona;

public class PersonaUtil {
    
        public static PersonaDTO convertToDTO(Persona persona) {
            PersonaDTO dto = new PersonaDTO();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dto.setCedulaIdentidad(persona.getCedulaIdentidad());
            dto.setNombreCompleto(persona.getNombres() + " " + persona.getApellidos());
            dto.setFechaNacimiento(dateFormat.format(persona.getFechaNacimiento()));
            return dto;
        }
    
        public static List<PersonaDTO> convertToDTO(List<Persona> personas) {
            return personas.stream().map(PersonaUtil::convertToDTO).collect(Collectors.toList());
        }
}
