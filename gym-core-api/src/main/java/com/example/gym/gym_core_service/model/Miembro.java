package com.example.gym.gym_core_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "miembro", schema = "clientes")
public class Miembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "miembro_id")
    @JsonIgnore
    private Long id;
    private String experiencia;
    private Float altura;
    private Float peso;

    @OneToOne
    @JoinColumn(name = "persona_id")
    private Persona informacionPersonal;

    @OneToOne
    @JoinColumn(name = "entrenador_id")
    @JsonIgnore
    private Empleado entrenador;
}
