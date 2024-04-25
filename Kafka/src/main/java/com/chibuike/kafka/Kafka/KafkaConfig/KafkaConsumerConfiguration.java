package com.chibuike.kafka.Kafka.KafkaConfig;

import com.chibuike.kafka.Kafka.Model.userModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfiguration {

    @Value("${spring.kafka.bootstrap-server}")
    private String bootstrapserver;



    public Map<String,Object> consumerConfig(){
        Map<String, Object> prop = new HashMap<>();
        prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapserver);
        prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserialize.class);
//        prop.put(JsonDeserializer.TRUSTED_PACKAGES, "com/chibuike/kafka/Kafka/Model/userModel.java");
        return prop;
    }

    @Bean
    public ConsumerFactory<String, userModel> consumerFactoryFactory (){
         DefaultKafkaConsumerFactory<String,userModel> cf = new DefaultKafkaConsumerFactory<>(consumerConfig(),
                 new JsonDeserializer<>(String.class).forKeys().ignoreTypeHeaders(),
                 new JsonDeserializer<>(userModel.class).ignoreTypeHeaders());

         return cf;
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,userModel>> factory(ConsumerFactory<String,userModel> consumerFactory){
        ConcurrentKafkaListenerContainerFactory<String,userModel> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}
