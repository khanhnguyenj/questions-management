package com.huongdanjava.questionservice;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.huongdanjava.questionservice.document.Question;
import com.huongdanjava.questionservice.repository.QuestionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepository;

	@GetMapping("/questions")
	public Flux<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	@PostMapping("/category")
	public Mono<Question> createQuestion(@Valid @RequestBody Question question) {
		return questionRepository.save(question);
	}

	@GetMapping("/category/{id}")
	public Mono<ResponseEntity<Question>> getQuestionById(@PathVariable(value = "id") Long questionId) {
		return questionRepository.findById(questionId)
			.map(question -> ResponseEntity.ok(question))
			.defaultIfEmpty(ResponseEntity.notFound().build());
	}

}
