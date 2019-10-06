package com.usbdemo.springkafka.configaurations;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.usbdemo.springkafka.Request.EmployeeRequest;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

	// Need to get the bootStrapAddress.
	@Value(value = "${kafka.bootstrapAddress}")
	public String bootstrapserverAddress;
	// need to define KafkaAdmin client

	public ConsumerFactory<String, EmployeeRequest> consumerFactory() {

		Map<String, Object> configs = new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapserverAddress);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "demogroup1");

		return new DefaultKafkaConsumerFactory<>(configs,
				new StringDeserializer()
				,new JsonDeserializer<>(EmployeeRequest.class));

	}
	
	@Bean
	ConcurrentKafkaListenerContainerFactory<String, EmployeeRequest> listenerContainerFactory(){
		
		ConcurrentKafkaListenerContainerFactory<String, EmployeeRequest> listenerContainerFactory
				= new ConcurrentKafkaListenerContainerFactory<>() ;
		
		listenerContainerFactory.setConsumerFactory(consumerFactory());
		
		return listenerContainerFactory;
		
	}

}
