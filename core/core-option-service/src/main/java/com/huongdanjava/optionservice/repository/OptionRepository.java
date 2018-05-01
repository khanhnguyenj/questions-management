package com.huongdanjava.optionservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.huongdanjava.optionservice.document.Option;

import reactor.core.publisher.Flux;

public interface OptionRepository extends ReactiveCrudRepository<Option, String> {

	Flux<Option> findByQuestionId(String questionId);
}
