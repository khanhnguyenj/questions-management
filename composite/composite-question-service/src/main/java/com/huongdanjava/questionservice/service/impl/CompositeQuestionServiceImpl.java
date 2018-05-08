package com.huongdanjava.questionservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huongdanjava.questionservice.dto.CompositeQuestion;
import com.huongdanjava.questionservice.dto.Question;
import com.huongdanjava.questionservice.service.CompositeQuestionService;
import com.huongdanjava.questionservice.service.OptionService;
import com.huongdanjava.questionservice.service.QuestionService;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
public class CompositeQuestionServiceImpl implements CompositeQuestionService {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private OptionService optionService;

    @Override
    public Flux<CompositeQuestion> findQuestionsByCategoryId(String categoryId) {
		Flux<Question> questionsFromCoreQuestionService = questionService.getQuestions(categoryId);

		return questionsFromCoreQuestionService.flatMap(question ->
			optionService.getOptions(question.getId())
				.collectList()
				.map(options -> new CompositeQuestion(question.getId(), question.getDescription(), question.getCategoryId(), options)))
			.subscribeOn(Schedulers.elastic());
    }
}
