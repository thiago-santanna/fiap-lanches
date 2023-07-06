package com.tsswebapps.fiaplanches;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableFeignClients
public class FiapLanchesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiapLanchesApplication.class, args);
	}

}
