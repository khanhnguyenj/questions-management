package com.huongdanjava.questionservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.huongdanjava.questionservice.document.Question;
import reactor.core.publisher.Flux;

public interface QuestionRepository extends ReactiveCrudRepository<Question, String> {

    Flux<Question> findByCategoryId(String categoryId);
}
