package br.com.microservice.avaliadorcredito;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableRabbit
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class AvaliadorCreditoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AvaliadorCreditoApplication.class, args);
	}

}
