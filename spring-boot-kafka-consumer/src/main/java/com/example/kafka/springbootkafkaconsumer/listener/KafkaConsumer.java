package com.example.kafka.springbootkafkaconsumer.listener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafka.springbootkafkaconsumer.entity.User;

@Service
public class KafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	
    @KafkaListener(topics = "kafka.example", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
        LOGGER.info("Consumed message: {} ", message);
    }


    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message: " + user);
        LOGGER.info("Consumed JSON message: {}", user);
    }
}