package com.huongdanjava.questionservice.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class ServiceUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceUtil.class);

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	public URI obtainServiceUrl(String serviceId) {
		ServiceInstance serviceInstance = loadBalancerClient.choose(serviceId);

 		return serviceInstance.getUri();
	}

}
