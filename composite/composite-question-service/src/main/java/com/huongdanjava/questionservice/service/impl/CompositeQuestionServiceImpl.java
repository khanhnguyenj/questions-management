package com.huongdanjava.questionservice.service.impl;

import com.huongdanjava.questionservice.dto.Question;
import com.huongdanjava.questionservice.service.CategoryService;
import com.huongdanjava.questionservice.service.CompositeQuestionService;
import com.huongdanjava.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CompositeQuestionServiceImpl implements CompositeQuestionService {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public Flux<Question> findQuestionsByCategoryId(String categoryId) {
        return null;
    }
}
