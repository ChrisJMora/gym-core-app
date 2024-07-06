package com.example.gym.gym_core_service.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@DiscriminatorValue("Administrativo")
public class Administrador extends Empleado {
    
}
