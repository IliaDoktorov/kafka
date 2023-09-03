package com.kafka.config;

import com.kafka.dto.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
@EnableKafka
public class KafkaConfig {
    // org.springframework.kafka.core.DefaultKafkaConsumerFactory will be injected
    private final ConsumerFactory<String, UserMessage> consumerFactory;

    @Autowired
    public KafkaConfig(ConsumerFactory<String, UserMessage> consumerFactory) {
        this.consumerFactory = consumerFactory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserMessage> kafkaListenerContainerFactory(){
        // Allows to create consumers which will be process messages from several Kafka partitions simultaneously
        ConcurrentKafkaListenerContainerFactory<String, UserMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
        // number of threads(consumers) should be == number of partitions in kafka for specific topic
        factory.setConcurrency(4);
        factory.setConsumerFactory(consumerFactory);

        return factory;
    }
}
