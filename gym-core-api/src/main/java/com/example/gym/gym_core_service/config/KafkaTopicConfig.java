package com.example.gym.gym_core_service.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    
    @Bean
    NewTopic generateTopic() {

        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "300000"); // Espera en milisegundos : 5 min
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073341824"); // Tamaño máximo del segmento: 1 GB
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012"); // Tamaño máximo de cada mensaje

        return TopicBuilder.name("actualizar-cliente")
        .partitions(2)    
        .replicas(1)
        .configs(configurations)
        .build();
    }
    
}
