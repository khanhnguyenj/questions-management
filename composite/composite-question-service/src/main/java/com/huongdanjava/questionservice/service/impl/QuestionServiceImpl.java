package com.huongdanjava.questionservice.service.impl;

import com.huongdanjava.questionservice.dto.Question;
import com.huongdanjava.questionservice.service.QuestionService;
import com.huongdanjava.questionservice.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.net.URI;

@Service
public class QuestionServiceImpl implements QuestionService {

    private static final String QUESTION_SERVICE_NAME = "Question";

    @Autowired
    private ServiceUtil serviceUtil;

    @Autowired
    private WebClient webClient;

    @Override
    public String getServiceUrl() {
        return serviceUtil.obtainServiceUrl(QUESTION_SERVICE_NAME).toString();
    }

    @Override
    public Flux<Question> findQuestionsByCategoryId(String categoryId) {
        String url = getServiceUrl() + "/questions/" + categoryId;

        WebClient client = WebClient.create(url);
        return null;
    }

}
