package com.chibuike.kafka.Kafka.Listeners;

import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "first-topic", groupId = "groupID")
     void listener(String data){
        System.out.println("Kafka message " + data);
    }

    @org.springframework.kafka.annotation.KafkaListener(topics = "second-topic", groupId = "groupID")
    void secondListener(String data){
        System.out.println("second topic " + data);
    }
}
