package com.example.gym.gym_core_service.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@DiscriminatorValue("Entrenador")
public class Entrenador extends Empleado{
    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Miembro> clientes;
}
