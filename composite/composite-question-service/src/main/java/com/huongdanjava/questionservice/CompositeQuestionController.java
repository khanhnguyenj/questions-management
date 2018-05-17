package com.huongdanjava.questionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.huongdanjava.questionservice.dto.CompositeQuestion;
import com.huongdanjava.questionservice.service.CompositeQuestionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import reactor.core.publisher.Flux;

@RestController
public class CompositeQuestionController {

    @Autowired
    private CompositeQuestionService compositeQuestionService;

    @HystrixCommand(fallbackMethod = "findQuestionsByCategoryIdFallBack")
    @GetMapping("/{categoryId}/questions")
    public Flux<CompositeQuestion> findQuestionsByCategoryId(@PathVariable String categoryId) {
        return compositeQuestionService.findQuestionsByCategoryId(categoryId);
    }

    public Flux<CompositeQuestion> findQuestionsByCategoryIdFallBack(String categoryId) {
    	return Flux.empty();
    }

}
