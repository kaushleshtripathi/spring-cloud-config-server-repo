package com.spring.boot.microservices;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.boot.microservices.rabbitmq.Sender;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableConfigServer
@EnableSwagger2
@PropertySource(value = { "messages.properties" })
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@SpringBootApplication
public class SpringBootMicroservicesJpaApplication implements CommandLineRunner, ApplicationRunner {

	 @Autowired  
	 Sender sender;
	 
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservicesJpaApplication.class, args);
	}

	// this is callback method which get called automatically
	@Override
	public void run(String... args) throws Exception {
		 sender.send("Hello Messaging..!!!");
		 
		 String strArgs = Arrays.stream(args).collect(Collectors.joining("|"));
		 System.out.println("Application started with arguments:" + strArgs);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		String strArgs = Arrays.stream(arg0.getSourceArgs()).collect(Collectors.joining("|"));
	    System.out.println("Application started with arguments:" + strArgs);
		
	}
}
