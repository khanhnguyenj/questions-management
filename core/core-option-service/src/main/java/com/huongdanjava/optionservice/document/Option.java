package com.huongdanjava.optionservice.document;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Option {

	private String id;

	private String description;

	private String note;

	private Boolean isCorrect;

	private String questionId;
}
