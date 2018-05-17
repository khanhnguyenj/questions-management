package com.huongdanjava.questionservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompositeQuestion {

	private String id;

	private String description;

    private String categoryId;

	private List<Option> options;
}
