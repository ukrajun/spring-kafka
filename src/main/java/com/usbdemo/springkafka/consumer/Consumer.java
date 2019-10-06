package com.usbdemo.springkafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.usbdemo.springkafka.Request.EmployeeRequest;

@Service
public class Consumer {
	
	@KafkaListener(topics="demokafka",containerFactory="listenerContainerFactory")
	
	public void consume(EmployeeRequest employeeRequest) {
		
		System.out.println("Message consumed by client"+employeeRequest);
	}

}
