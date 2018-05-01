package com.huongdanjava.questionservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huongdanjava.questionservice.dto.Option;
import com.huongdanjava.questionservice.dto.Question;
import com.huongdanjava.questionservice.service.CompositeQuestionService;
import com.huongdanjava.questionservice.service.OptionService;
import com.huongdanjava.questionservice.service.QuestionService;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

@Service
public class CompositeQuestionServiceImpl implements CompositeQuestionService {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private OptionService optionService;

    @Override
    public Flux<Question> findQuestionsByCategoryId(String categoryId) {
    		Flux<Question> questionsFromCoreQuestionService = questionService.getQuestions(categoryId);

    		Test t = new Test();

		questionsFromCoreQuestionService.subscribe(t);

		return questionsFromCoreQuestionService;
    }

    class Test extends BaseSubscriber<Question> {
    		private Question question;

    		@Override
    		protected void hookOnNext(Question value) {
    			System.err.println("Khanh");
    			this.question = value;
    			System.out.println(question.getDescription());
    			Flux<Option> options = optionService.getOptions(question.getId());
    			System.out.println(options.blockFirst().getDescription());
    			Option option = new Option();
    			option.setDescription("Khanhaaa");
			question.setOptions(Flux.just(option));
			request(1);
    		}
    }
}
