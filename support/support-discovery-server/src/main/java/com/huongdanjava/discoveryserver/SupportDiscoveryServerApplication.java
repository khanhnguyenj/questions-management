package com.huongdanjava.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SupportDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupportDiscoveryServerApplication.class, args);
	}
}
