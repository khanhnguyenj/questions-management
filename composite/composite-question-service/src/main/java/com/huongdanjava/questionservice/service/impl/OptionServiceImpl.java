package com.huongdanjava.questionservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.huongdanjava.questionservice.dto.Option;
import com.huongdanjava.questionservice.service.OptionService;
import com.huongdanjava.questionservice.util.ServiceUtil;

import reactor.core.publisher.Flux;

@Service
public class OptionServiceImpl implements OptionService {

	private static final String OPTION_SERVICE_NAME = "Core Option Service";

    @Autowired
    private ServiceUtil serviceUtil;

    @Override
    public String getServiceUrl() {
        return serviceUtil.obtainServiceUrl(OPTION_SERVICE_NAME).toString();
    }

	@Override
	public Flux<Option> getOptions(String questionId) {
		WebClient client = WebClient
	            .builder()
	            .baseUrl(getServiceUrl())
	            .build();

	        WebClient.ResponseSpec responseSpec = client
	            .get()
	            .uri("/options/" + questionId)
	            .retrieve();

	        return responseSpec.bodyToFlux(Option.class);
	}

}
