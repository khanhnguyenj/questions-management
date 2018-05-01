package com.huongdanjava.questionservice.dto;

import lombok.Data;
import reactor.core.publisher.Flux;

@Data
public class Question {

	private String id;

	private String description;

    private String categoryId;

    private Flux<Option> options;

}
