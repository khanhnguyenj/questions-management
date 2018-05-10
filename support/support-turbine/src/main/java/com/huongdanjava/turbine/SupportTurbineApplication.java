package com.huongdanjava.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@EnableTurbineStream
@EnableDiscoveryClient
@SpringBootApplication
public class SupportTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupportTurbineApplication.class, args);
	}
}
