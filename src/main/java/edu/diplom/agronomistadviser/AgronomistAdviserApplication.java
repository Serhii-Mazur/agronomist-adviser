package edu.diplom.agronomistadviser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@EnableAsync
public class AgronomistAdviserApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgronomistAdviserApplication.class, args);
	}

}
