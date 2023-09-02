package com.kafka.consumer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@EnableKafka
public class KafkaConfig {
    // org.springframework.kafka.core.DefaultKafkaConsumerFactory will be injected
    private final ConsumerFactory<Object, Object> consumerFactory;
    private final ProducerFactory<Object, Object> producerFactory;

    @Autowired
    public KafkaConfig(ConsumerFactory<Object, Object> consumerFactory, ProducerFactory<Object, Object> producerFactory) {
        this.consumerFactory = consumerFactory;
        this.producerFactory = producerFactory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Object, Object> kafkaListenerContainerFactory(){
        // Allows to create consumers which will be process messages from several Kafka partitions simultaneously
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConcurrency(1);
        factory.setConsumerFactory(consumerFactory);

        return factory;
    }
}
