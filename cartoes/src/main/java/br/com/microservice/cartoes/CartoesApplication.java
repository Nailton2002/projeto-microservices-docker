package br.com.microservice.cartoes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@Slf4j
@EnableRabbit
@EnableEurekaClient
@SpringBootApplication
public class CartoesApplication {

	public static void main(String[] args) {
		log.info("Informação:  {}", "teste info");
		log.error("Erro: {}", "teste erro");
		log.warn("Aviso:  {}", "teste aviso");
		SpringApplication.run(CartoesApplication.class, args);
	}

}
