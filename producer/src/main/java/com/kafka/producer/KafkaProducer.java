package com.kafka.producer;

import com.kafka.dto.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class KafkaProducer {
    private final KafkaTemplate<String, UserMessage> kafkaTemplate;


    private final String topicName;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, UserMessage> kafkaTemplate, @Value("${kafka.topics.message-topic}") String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    public void generateMessages(){
        UserMessage userMessage;
        for(long i = 0; i < 100; i++){
            userMessage = new UserMessage("user" + i, "email" + i + "@mail.com");

            kafkaTemplate.send(topicName, String.valueOf(i), userMessage);

            System.out.println("Message: " + userMessage);
        }
    }
}
