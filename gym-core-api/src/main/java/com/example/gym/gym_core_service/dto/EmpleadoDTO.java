package com.example.gym.gym_core_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmpleadoDTO {
    @JsonProperty("cedula_identidad")
    private int cedulaIdentidad;
    @JsonProperty("nombre_completo")
    private String nombreCompleto;
    @JsonProperty("cargo")
    private String cargo;
}
