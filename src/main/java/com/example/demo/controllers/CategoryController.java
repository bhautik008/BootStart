package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BookRepository;
import com.example.demo.dao.CategoryRepository;
import com.example.demo.domain.Category;

@RestController
public class CategoryController {
	
	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping(path="/categories", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Category> getCategories(){
		return categoryRepository.findAll();
	}
	
	@GetMapping(path="/category/{categoryId}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Category getCategory(@PathVariable("categoryId") int categoryId) {
		return categoryRepository.findById(categoryId).orElse(null);
	}
	
	@PostMapping(path="/addCategory", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	@PostMapping(path="/updateCategory/{categoryId}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Category updateCategory(@PathVariable("categoryId") int categoryId, Category category) {
		return categoryRepository.save(category);
	}
	
	@DeleteMapping(path="/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int categoryId) {
		Category category = categoryRepository.findById(categoryId).orElse(null);
		categoryRepository.delete(category);
		return "Category Deleted!!!";
	}
}