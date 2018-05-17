package com.huongdanjava.questionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableCircuitBreaker
@EnableSwagger2
@EnableHystrix
@SpringBootApplication
public class CompositeQuestionServiceApplication {

	@Bean
	public Docket apis() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.huongdanjava.questionservice"))
			.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(CompositeQuestionServiceApplication.class, args);
	}
}
