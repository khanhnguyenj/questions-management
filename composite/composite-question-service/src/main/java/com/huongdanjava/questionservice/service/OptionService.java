package com.huongdanjava.questionservice.service;

import com.huongdanjava.questionservice.dto.Option;

import reactor.core.publisher.Flux;

public interface OptionService {

	String getServiceUrl();

	Flux<Option> getOptions(String questionId);
}
