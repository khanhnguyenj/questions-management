package com.huongdanjava.questionservice.service;

import com.huongdanjava.questionservice.dto.Question;
import reactor.core.publisher.Flux;

public interface CompositeQuestionService {

    Flux<Question> findQuestionsByCategoryId(String categoryId);
}
