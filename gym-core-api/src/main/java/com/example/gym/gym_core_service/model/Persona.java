package com.example.gym.gym_core_service.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "persona", schema = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id")
    @JsonIgnore
    private Long id;
    @Column(name = "cedula_identidad")
    private Integer cedulaIdentidad;
    private String nombres;
    private String apellidos;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
}
