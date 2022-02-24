package com.example.kafka.springbootkafkaproducer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.support.serializer.ToStringSerializer;

import com.example.kafka.springbootkafkaproducer.entity.User;



@Configuration
public class KafkaConfiguration {
	
	@Bean
	public ProducerFactory<String, User> producerFactory() {
		
		Map<String,Object> configMap=new HashMap<>();
		configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, ToStringSerializer.class);
		configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configMap);
	}
	
	@Bean
	public KafkaTemplate<String, User> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
}
