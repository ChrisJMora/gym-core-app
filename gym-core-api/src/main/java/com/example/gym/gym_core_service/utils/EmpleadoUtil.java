package com.example.gym.gym_core_service.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.example.gym.gym_core_service.dto.EmpleadoDTO;
import com.example.gym.gym_core_service.model.Empleado;
import com.example.gym.gym_core_service.model.Persona;

public class EmpleadoUtil {

    public static EmpleadoDTO convertToDTO(Empleado empleado) {
        EmpleadoDTO dto = new EmpleadoDTO();
        Persona informacionPersonal = empleado.getInformacionPersonal();
        dto.setId(empleado.getId());
        dto.setCedulaIdentidad(informacionPersonal.getCedulaIdentidad());
        dto.setNombreCompleto(informacionPersonal.getNombres() + " " + informacionPersonal.getApellidos());
        dto.setCargo(empleado.getCargo());
        return dto;
    }

    public static List<EmpleadoDTO> convertToDTO(List<Empleado> empleados) {
        return empleados.stream().map(EmpleadoUtil::convertToDTO).collect(Collectors.toList());
    }
}
