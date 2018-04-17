package com.huongdanjava.questionservice;

import com.huongdanjava.questionservice.dto.Question;
import com.huongdanjava.questionservice.service.CompositeQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class CompositeQuestionController {

    @Autowired
    private CompositeQuestionService compositeQuestionService;

    @GetMapping("/{categoryId}/questions")
    public Flux<Question> findQuestionsByCategoryId(@PathVariable String categoryId) {
        return compositeQuestionService.findQuestionsByCategoryId(categoryId);
    }

}
