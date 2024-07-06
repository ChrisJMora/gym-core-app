package com.example.gym.gym_core_service.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Cargo {
    ADMINISTRATIVO("Administrativo"),	
    ENTRENADOR("Entrenador");

    private final String value;
}
