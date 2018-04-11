package com.huongdanjava.questionservice.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;

@Component
public class UrlUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(UrlUtil.class);

	@Autowired
	private LoadBalancerClient loadBalancerClient;

}
