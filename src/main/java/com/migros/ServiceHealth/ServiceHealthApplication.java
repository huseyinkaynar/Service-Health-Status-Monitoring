package com.migros.ServiceHealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling

@EnableAutoConfiguration
public class ServiceHealthApplication {


	public static void main(String[] args)  { SpringApplication.run(ServiceHealthApplication.class, args);


	}
}
