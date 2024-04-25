package com.chibuike.kafka.Kafka.Controller;


import com.chibuike.kafka.Kafka.KafkaApplication;
import com.chibuike.kafka.Kafka.KafkaConfig.KafkaProducerConfiguration;
import com.chibuike.kafka.Kafka.Model.userModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class Controller {
    public KafkaTemplate<String,userModel>kafkaTemplate;


    public Controller(KafkaTemplate<String, userModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/post/")
    public userModel send(@ModelAttribute userModel userModel){
        kafkaTemplate.send("first-topic", userModel);
//        kafkaTemplate.send("second-topic", userModel);
        return userModel;

    }
}
