package com.huongdanjava.optionservice.document;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Option {

	private String description;

	private String questionId;
}
