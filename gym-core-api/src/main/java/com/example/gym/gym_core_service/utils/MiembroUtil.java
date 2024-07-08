package com.example.gym.gym_core_service.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.example.gym.gym_core_service.dto.MiembroDTO;
import com.example.gym.gym_core_service.model.Miembro;
import com.example.gym.gym_core_service.model.Persona;

public class MiembroUtil {
    public static MiembroDTO convertToDTO(Miembro miembro) {
        MiembroDTO dto = new MiembroDTO();
        Persona informacionPersonal = miembro.getInformacionPersonal();
        dto.setCedulaIdentidad(informacionPersonal.getCedulaIdentidad());
        dto.setNombreCompleto(informacionPersonal.getNombres() + " " + informacionPersonal.getApellidos());
        dto.setExperiencia(miembro.getExperiencia());
        dto.setPeso(miembro.getPeso());
        dto.setAltura(miembro.getAltura());
        return dto;
    }

    public static List<MiembroDTO> convertToDTO(List<Miembro> miembros) {
        return miembros.stream().map(MiembroUtil::convertToDTO).collect(Collectors.toList());
    }
}
