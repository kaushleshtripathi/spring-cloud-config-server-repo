package com.spring.boot.microservices.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	
	@RabbitListener(queues = "TestQ")
	public void processMessage(String content) {
		System.out.println("TTTTTTTTTTTTTTTTT: "+content);
	}
}
