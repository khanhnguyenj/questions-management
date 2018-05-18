package com.huongdanjava.categoryservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.huongdanjava.categoryservice.document.Category;

public interface CategoryRepository extends ReactiveCrudRepository<Category, String> {

}
