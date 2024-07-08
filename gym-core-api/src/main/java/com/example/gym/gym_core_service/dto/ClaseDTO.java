package com.example.gym.gym_core_service.dto;

import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClaseDTO {
    @JsonProperty("actividad")
    private String actividad;
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("dia")
    private String dia;
    @JsonProperty("hora_inicio")
    private Time horaInicio;
    @JsonProperty("hora_fin")
    private Time horaFin;
}
