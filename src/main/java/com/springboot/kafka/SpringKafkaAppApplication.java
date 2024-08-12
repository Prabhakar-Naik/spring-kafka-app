package com.springboot.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.kafka.config.KafkaConfigProps;
import com.springboot.kafka.domain.My_topicEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class SpringKafkaAppApplication {

	@Autowired
	private ObjectMapper objectMapper;

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaAppApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(KafkaTemplate<String,String> template, final KafkaConfigProps kafkaConfigProps) throws JsonProcessingException {

			final My_topicEvent event = My_topicEvent.builder()
					.topic_id(UUID.randomUUID().toString())
					.dateTime(LocalDateTime.now())
					.build();

			final String payload = objectMapper.writeValueAsString(event);
			return args -> {
				template.send(kafkaConfigProps.getTopic(),payload);
			};
	}

	@KafkaListener(topics = "my_topic")
	public String listens(final String in){
		System.out.println(in);
		return in;
	}

}
