package com.example.gym.gym_core_service.model;

import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "evento", schema = "itinerario")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evento_id")
    @JsonIgnore
    private long id;

    @Column(name = "hora_inicio")
    @JsonProperty("hora_inicio")
    private Time horaInicio;

    @Column(name = "hora_fin")
    @JsonProperty("hora_fin")
    private Time horaFin;

    @Column(name = "dia")
    @JsonProperty("dia")
    private String dia;
}
