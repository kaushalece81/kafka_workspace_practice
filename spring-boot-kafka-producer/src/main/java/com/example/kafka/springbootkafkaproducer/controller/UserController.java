package com.example.kafka.springbootkafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class UserController {
	
	private static final String TOPIC_NAME = "kafka.example";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
//	@Autowired
//	private KafkaTemplate<String, User> kafkaTemplateUser;
	
	
	
	@GetMapping("/publish/{message}")
	public String publishMessage(@PathVariable("message") final String message) {
		kafkaTemplate.send(TOPIC_NAME, message);
		return "Message Published Successfully";
	}
	
//	@PostMapping("/publish/user")
//	public String publishUser(@RequestBody final User user) {
//		kafkaTemplateUser.send(TOPIC_NAME, user);
//		return "Message Published Successfully";
//	}

}
