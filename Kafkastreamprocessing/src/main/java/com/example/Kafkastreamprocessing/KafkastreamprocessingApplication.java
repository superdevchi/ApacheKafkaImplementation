package com.example.Kafkastreamprocessing;

import com.example.Kafkastreamprocessing.Model.userModel;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class KafkastreamprocessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkastreamprocessingApplication.class, args);
	}



	@Bean
	public Function<KStream<String, userModel>, KStream<String, userModel>> sendtonexttopic() {

		return kstream -> kstream.filter((key, domain) -> {
			System.out.println(domain);
			return true;
		});

	}
}
