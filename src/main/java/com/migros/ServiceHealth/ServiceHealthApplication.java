package com.migros.ServiceHealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableScheduling
public class ServiceHealthApplication {


	public static void main(String[] args) throws InterruptedException { SpringApplication.run(ServiceHealthApplication.class, args);


	}



}
