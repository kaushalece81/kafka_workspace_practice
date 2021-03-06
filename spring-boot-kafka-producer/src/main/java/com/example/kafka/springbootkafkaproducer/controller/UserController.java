package com.example.kafka.springbootkafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.springbootkafkaproducer.entity.User;

@RestController
@RequestMapping("/kafka")
public class UserController {
	
	private static final String TOPIC_NAME = "kafka.example";
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	
	@PostMapping("/publish/user")
	public String publishUser(@RequestBody final User user) {
		kafkaTemplate.send(TOPIC_NAME, user);
		return "Message Published Successfully";
	}

}
