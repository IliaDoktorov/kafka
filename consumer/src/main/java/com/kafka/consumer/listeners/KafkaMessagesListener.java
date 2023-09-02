package com.kafka.consumer.listeners;

import com.kafka.consumer.dto.UserMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessagesListener {

    @KafkaListener(
            id = "consumer-group-1",
            topics = "${kafka.topics.message-topic}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void processMessage(UserMessage message){
        System.out.println(message);
    }
}
