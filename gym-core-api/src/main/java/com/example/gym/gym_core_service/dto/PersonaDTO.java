package com.example.gym.gym_core_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonaDTO {
    @JsonProperty("cedula_identidad")
    private long cedulaIdentidad;
    @JsonProperty("nombre_completo")
    private String nombreCompleto;
    @JsonProperty("fecha_nacimiento")
    private String fechaNacimiento;
}
