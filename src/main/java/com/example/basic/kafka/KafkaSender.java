package com.example.basic.kafka;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/*@Service
public class KafkaSender {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private KafkaTemplate<String,String> kafkaTemplate;
	
	@Value("${topic.name}")
	private String topic;

	public KafkaSender(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	
public void send(String data) {
	    
		LOGGER.info("message sent to the topic: {}",topic);
	   // kafkaTemplate.send(kafkaTopic, 0, data);
	    kafkaTemplate.send(topic, data);
	    //kafkaTemplate.send(topic,0, data);
	}
}*/
