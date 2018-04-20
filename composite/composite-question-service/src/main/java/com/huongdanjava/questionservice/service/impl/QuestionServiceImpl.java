package com.huongdanjava.questionservice.service.impl;

import com.huongdanjava.questionservice.dto.Question;
import com.huongdanjava.questionservice.service.QuestionService;
import com.huongdanjava.questionservice.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class QuestionServiceImpl implements QuestionService {

    private static final String QUESTION_SERVICE_NAME = "Core Question Service";

    @Autowired
    private ServiceUtil serviceUtil;

    @Override
    public String getServiceUrl() {
        return serviceUtil.obtainServiceUrl(QUESTION_SERVICE_NAME).toString();
    }

    @Override
    public Flux<Question> findQuestionsByCategoryId(String categoryId) {
        WebClient client = WebClient
            .builder()
            .baseUrl(getServiceUrl())
            .build();

        WebClient.ResponseSpec responseSpec = client
            .get()
            .uri("/questions/" + categoryId)
            .retrieve();

        return responseSpec.bodyToFlux(Question.class);
    }

}
