package com.migros.ServiceHealth;

import com.migros.ServiceHealth.Model.CheckServices;
import com.migros.ServiceHealth.Service.CheckStatusService;
import com.sun.codemodel.internal.JForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;


@SpringBootApplication
@EnableScheduling
public class ServiceHealthApplication /*implements CommandLineRunner*/ {
	@Autowired
	private CheckStatusService checkStatusService;

	public static void main(String[] args) throws InterruptedException { SpringApplication.run(ServiceHealthApplication.class, args);



	}
	/*@Override
	public void run(String... args) {

			checkStatusService.scheduling();



	}*/


}
