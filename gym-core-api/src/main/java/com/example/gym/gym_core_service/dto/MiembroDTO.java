package com.example.gym.gym_core_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MiembroDTO {
    @JsonProperty("cedula_identidad")
    private long cedulaIdentidad;
    @JsonProperty("nombre_completo")
    private String nombreCompleto;
    @JsonProperty("experiencia")
    private String experiencia;
    @JsonProperty("peso")
    private float peso;
    @JsonProperty("altura")
    private float altura;
}
