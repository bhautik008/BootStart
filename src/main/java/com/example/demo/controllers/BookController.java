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
import com.example.demo.domain.Book;
import com.example.demo.domain.Category;

@RestController
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping(path="/books", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Book> getBooks(){
		return bookRepository.findAll();
	}
	
	@GetMapping(path="/book/{bookId}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Book getBook(@PathVariable("bookId") int bookId) {
		return bookRepository.findById(bookId).orElse(null);
	}
	
	@GetMapping(path="/books/{categoryId}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Book> getBooksByCategory(@PathVariable("categoryId") int categoryId){
		return bookRepository.findByCategoryCategoryId(categoryId);
	}
	
	@PostMapping(path="/addBook/{categoryId}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Book addBook(@PathVariable("categoryId") int categoryId, Book book){
		Category category = categoryRepository.findById(categoryId).orElse(new Category());
		book.setCategory(category);
		return bookRepository.save(book);
	}
	
	@PostMapping(path="/updateBook/{categoryId}/{bookId}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Book updateBook(@PathVariable("categoryId") int categoryId, @PathVariable("bookId") int bookId, Book book) {
		Category category = categoryRepository.findById(categoryId).orElse(new Category());
		book.setCategory(category);
		return bookRepository.save(book);
	}
	
	@DeleteMapping(path="/deleteBook/{bookId}")
	public String deleteBook(@PathVariable("bookId") int bookId) {
		Book book = bookRepository.findById(bookId).orElse(null);
		bookRepository.delete(book);
		return "Book Deleted!!!";
	}
}
