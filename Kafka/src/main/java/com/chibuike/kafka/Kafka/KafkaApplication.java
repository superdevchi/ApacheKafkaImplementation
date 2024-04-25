package com.chibuike.kafka.Kafka;

import com.chibuike.kafka.Kafka.Model.userModel;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.util.Properties;

@SpringBootApplication
public class KafkaApplication {


	public static void main(String[] args) {

		SpringApplication.run(KafkaApplication.class, args);

	}

}
