package com.huongdanjava.questionservice.service;

import com.huongdanjava.questionservice.dto.CompositeQuestion;

import reactor.core.publisher.Flux;

public interface CompositeQuestionService {

    Flux<CompositeQuestion> findQuestionsByCategoryId(String categoryId);
}
