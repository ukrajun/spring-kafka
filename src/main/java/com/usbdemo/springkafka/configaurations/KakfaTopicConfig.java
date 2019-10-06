package com.usbdemo.springkafka.configaurations;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
@EnableKafka
public class KakfaTopicConfig {
	
	
	// Need to get teh bootStrapAddress.
	@Value(value="${kafka.bootstrapAddress}")
	public String bootstrapserverAddress;
	//need to define KafkaAdmin client
	
	@Bean
	KafkaAdmin  kafkaAdmin () {
		Map<String,Object> configs = new HashMap<String,Object>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapserverAddress);
		return new KafkaAdmin(configs);
		
	}
	
	@Bean
	NewTopic NewTopic() {
		return new NewTopic("demokafka",1,(short)1);
	}
}
