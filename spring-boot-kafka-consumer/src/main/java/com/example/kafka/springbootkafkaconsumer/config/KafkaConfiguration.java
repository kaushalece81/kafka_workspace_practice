package com.example.kafka.springbootkafkaconsumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.kafka.springbootkafkaconsumer.entity.User;

/*Keep an eye on kafka listener to handle below annotation
Spring boot provides an auto configuration for Kafka via KafkaAutoConfiguration class (javadoc). 
When you use @EnableAutoConfiguration or @SpringBootApplication, Spring boot automatically configures Kafka for you.
If you don't use Spring boot, then you would have to use @EnableKafka to configure Kafka for your Spring app.
*/
//@EnableKafka
@Configuration
public class KafkaConfiguration {

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		
		Map<String,Object> configMap=new HashMap<>();
		configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		configMap.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(configMap);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String,String> factory =new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
	@Bean
    public ConsumerFactory<String, User> userConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                new JsonDeserializer<>(User.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, User> userKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, User> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(userConsumerFactory());
        return factory;
    }
}
