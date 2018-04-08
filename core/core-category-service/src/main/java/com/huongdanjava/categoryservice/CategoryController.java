package com.huongdanjava.categoryservice;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.huongdanjava.categoryservice.document.Category;
import com.huongdanjava.categoryservice.repository.CategoryRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/categories")
	public Flux<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@PostMapping("/category")
	public Mono<Category> createCategory(@Valid @RequestBody Category category) {
		return categoryRepository.save(category);
	}

	@GetMapping("/category/{id}")
    public Mono<ResponseEntity<Category>> getCategoryById(@PathVariable(value = "id") Long categoryId) {
        return categoryRepository.findById(categoryId)
			.map(category -> ResponseEntity.ok(category))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

	@PutMapping("/category/{id}")
    public Mono<ResponseEntity<Category>> updateCategory(
    	@PathVariable(value = "id") Long categoryId,
    	@Valid @RequestBody Category category) {
        return categoryRepository.findById(categoryId)
            .flatMap(existingCategory -> {
            	existingCategory.setName(category.getName());

                return categoryRepository.save(existingCategory);
            })
            .map(updatedCategory -> new ResponseEntity<>(updatedCategory, HttpStatus.OK))
            .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

	@DeleteMapping("/category/{id}")
	public Mono<ResponseEntity<Void>> deleteCategory(@PathVariable(value = "id") Long categoryId) {
		return categoryRepository.findById(categoryId)
			.flatMap(existingCategory ->
				categoryRepository.delete(existingCategory)
					.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
			.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
