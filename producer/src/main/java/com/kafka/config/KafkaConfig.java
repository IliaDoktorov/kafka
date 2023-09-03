package com.kafka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@EnableKafka
public class KafkaConfig {
    private final ProducerFactory<Object, Object> producerFactory;

    @Autowired
    public KafkaConfig(ProducerFactory<Object, Object> producerFactory) {
        this.producerFactory = producerFactory;
    }
}
