package com.huongdanjava.questionservice.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Question {
	
	@Id
	private String id;
	
	private String description;
	
	private Long categoryId;

}
