package com.example.gym.gym_core_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.gym.gym_core_service.dto.MiembroDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaProvider {
    
    private static final String TOPIC = "actualizar-cliente";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMiembro(MiembroDTO miembro) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String userJson = objectMapper.writeValueAsString(miembro);
            kafkaTemplate.send(TOPIC, userJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
