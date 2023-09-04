package com.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@EnableKafka
public class KafkaConfig {
    private final ProducerFactory<Object, Object> producerFactory;

    @Autowired
    public KafkaConfig(ProducerFactory<Object, Object> producerFactory) {
        this.producerFactory = producerFactory;
    }

    @Bean
    public NewTopic topic(){
        return TopicBuilder
                .name("user_message_topic")
                .partitions(4)
                .replicas(2)
                .build();
    }
}
