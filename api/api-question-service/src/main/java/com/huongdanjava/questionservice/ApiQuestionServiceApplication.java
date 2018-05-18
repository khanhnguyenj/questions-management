package com.huongdanjava.questionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableCircuitBreaker
@EnableSwagger2
@EnableHystrix
@SpringBootApplication
public class ApiQuestionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiQuestionServiceApplication.class, args);
	}
}
