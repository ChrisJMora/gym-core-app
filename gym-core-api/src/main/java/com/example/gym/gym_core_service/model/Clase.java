package com.example.gym.gym_core_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "clase", schema = "itinerario")
public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clase_id")
    @JsonIgnore
    private long id;

    @OneToOne
    @JoinColumn (name = "entrenador_id")
    @JsonIgnore
    private Entrenador entrenador;

    @OneToOne
    @JoinColumn (name = "actividad_id")
    @JsonProperty("actividad")
    private Actividad actividad;

    @OneToOne
    @JoinColumn (name = "evento_id")
    @JsonProperty("evento")
    private Evento evento;
}
