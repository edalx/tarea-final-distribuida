package com.eacuji;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.eacuji")
@EnableRabbit
public class MicroservicioArtistasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioArtistasApplication.class, args);
	}
}
