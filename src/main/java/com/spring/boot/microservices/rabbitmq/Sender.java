package com.spring.boot.microservices.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component 
public class Sender {

	@Autowired
	RabbitTemplate template;

	@Bean
	Queue queue() {
		return new Queue("TestQ", false);
	}

	public void send(String message) {
		template.convertAndSend("TestQ", message);
	}
}
