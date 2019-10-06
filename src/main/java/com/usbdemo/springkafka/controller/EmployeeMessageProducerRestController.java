package com.usbdemo.springkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usbdemo.springkafka.Request.EmployeeRequest;

@RestController
@RequestMapping("/producer")
public class EmployeeMessageProducerRestController {
	
	public static final String TOPIC ="demokafka";
	
	@Autowired
	KafkaTemplate<String, EmployeeRequest> kafkaTemplate ;
	
	@PostMapping("/message")
	public String produce(@RequestBody EmployeeRequest employeeRequest) {
		
		kafkaTemplate.send(TOPIC, employeeRequest);
		
		return "Message Published successfully";
	}

}
