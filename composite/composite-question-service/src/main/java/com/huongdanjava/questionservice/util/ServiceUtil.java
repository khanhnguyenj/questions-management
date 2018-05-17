package com.huongdanjava.questionservice.util;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;

@Component
public class ServiceUtil {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	public URI obtainServiceUrl(String serviceId) {
		ServiceInstance serviceInstance = loadBalancerClient.choose(serviceId);

 		return serviceInstance.getUri();
	}

}
