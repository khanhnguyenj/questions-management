package com.huongdanjava.optionservice;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.huongdanjava.optionservice.document.Option;
import com.huongdanjava.optionservice.repository.OptionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class OptionController {

	@Autowired
	private OptionRepository optionRepository;

	@GetMapping("/options/{questionId}")
	public Flux<Option> findByQuestionId(@PathVariable String questionId) {
		return optionRepository.findByQuestionId(questionId);
	}

	@PostMapping("/option")
	public Mono<Option> createOption(@Valid @RequestBody Option option) {
		return optionRepository.save(option);
	}

	@GetMapping("/option/{id}")
	public Mono<ResponseEntity<Option>> findById(@PathVariable(value = "id") String optionId) {
		return optionRepository.findById(optionId)
			.map(option -> ResponseEntity.ok(option))
			.defaultIfEmpty(ResponseEntity.notFound().build());
	}
}
