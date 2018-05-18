package com.huongdanjava.edgeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SupportEdgeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupportEdgeServerApplication.class, args);
	}
}
