package com.chibuike.kafka.Kafka.KafkaConfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

//    making topic for broker

    @Bean
    public NewTopic firstTopic(){
        return TopicBuilder.name("first-topic").build();
    }

    @Bean
    public NewTopic firstTopic2(){
        return TopicBuilder.name("second-topic").build();
    }
}
