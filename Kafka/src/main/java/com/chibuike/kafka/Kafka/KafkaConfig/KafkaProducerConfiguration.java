package com.chibuike.kafka.Kafka.KafkaConfig;

import com.chibuike.kafka.Kafka.Model.userModel;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfiguration {

    @Value("${spring.kafka.bootstrap-server}")
    private String bootstrapserver;




    public Map<String,Object> producerConfig(){
        Map<String, Object> prop = new HashMap<>();
        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapserver);
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerialize.class);

        return prop;
    }

    @Bean
    public ProducerFactory<String, userModel> producerFactory (

    ){
          DefaultKafkaProducerFactory<String,userModel> pf = new DefaultKafkaProducerFactory<>(producerConfig(),
                  new JsonSerializer<String>()
                          .forKeys()
                          .noTypeInfo(),
                  new JsonSerializer<userModel>().noTypeInfo()
                  );

          return pf;
    }

    @Bean
    public KafkaTemplate<String, userModel>kafkaTemplate (
//            dependency injecct
            ProducerFactory<String,userModel> producerFactory
    ){
        return new KafkaTemplate<>(producerFactory);
    }
}
