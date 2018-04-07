package com.huongdanjava.questionservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.huongdanjava.questionservice.document.Question;

public interface QuestionRepository extends ReactiveCrudRepository<Question, Long> {

}
