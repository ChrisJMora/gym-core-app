package com.example.gym.gym_core_service.dto;

import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SesionDTO {
    @JsonProperty("entrenador")
    private String entrenador;
    @JsonProperty("dia")
    private String dia;
    @JsonProperty("hora_inicio")
    private Time horaInicio;
    @JsonProperty("hora_fin")
    private Time horaFin;
}
