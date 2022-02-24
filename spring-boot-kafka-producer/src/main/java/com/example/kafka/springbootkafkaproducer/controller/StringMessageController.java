package com.example.kafka.springbootkafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.springbootkafkaproducer.entity.User;

@RestController
@RequestMapping("/kafka/string")
public class StringMessageController {
	
	private static final String TOPIC_NAME = "kafka.example";
	
//	@Autowired
//	private KafkaTemplate<String, String> kafkaTemplate;
//
//	@PostMapping("/publish/{message}")
//	public String publishMessage(@PathVariable("message") final String message) {
//		kafkaTemplate.send(TOPIC_NAME, message);
//		return "Message Published Successfully";
//	}

}
