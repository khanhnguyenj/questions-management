package com.huongdanjava.coreoptionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CoreOptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreOptionServiceApplication.class, args);
	}
}
