package com.kafka.listeners;

import com.kafka.dto.UserMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessagesListener {

    @KafkaListener(
            id = "consumer-group-1",
            topics = "${kafka.topics.message-topic}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void processMessage1(@Payload UserMessage message){
        printMessage(message);
    }

    @KafkaListener(
            id = "consumer-group-2",
            topics = "${kafka.topics.message-topic}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void processMessage2(@Payload UserMessage message){
        printMessage(message);
    }

    public void printMessage(UserMessage userMessage){
        System.out.println(userMessage);
    }
}
