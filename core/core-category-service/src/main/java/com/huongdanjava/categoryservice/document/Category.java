package com.huongdanjava.categoryservice.document;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Category {

	@Id
	private String id;

	@NotBlank
	private String code;

	@NotBlank
	private String name;

	private String description;
}
