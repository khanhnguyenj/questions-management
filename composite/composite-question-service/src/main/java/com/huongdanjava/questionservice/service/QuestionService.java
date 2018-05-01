package com.huongdanjava.questionservice.service;

import com.huongdanjava.questionservice.dto.Question;

import reactor.core.publisher.Flux;

public interface QuestionService {

    String getServiceUrl();

    Flux<Question> getQuestions(String categoryId);
}
