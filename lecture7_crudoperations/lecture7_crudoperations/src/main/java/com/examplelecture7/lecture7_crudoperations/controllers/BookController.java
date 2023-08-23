package com.examplelecture7.lecture7_crudoperations.controllers;
import java.util.List;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examplelecture7.lecture7_crudoperations.Bookrequests.BookCreateRequests;
import com.examplelecture7.lecture7_crudoperations.Bookrequests.BookUpdateRequest;
import com.examplelecture7.lecture7_crudoperations.models.Book;
import com.examplelecture7.lecture7_crudoperations.services.BookService;

import jakarta.validation.Valid;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	
	@GetMapping("/get/book")
	public Book getBook(@RequestParam("id") int id) throws SQLException {
		return bookService.getBook(id);
	}
	
	@GetMapping("/get/allBooks")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@PostMapping("/add/Book")
	public void insertBook(@Valid @RequestBody BookCreateRequests bookCreateRequests) throws SQLException {
		Book book= new Book();
		book.setAuthorName(bookCreateRequests.getAuthorName());
		book.setName(bookCreateRequests.getName());
		book.setCost(bookCreateRequests.getCost());
		
		bookService.insert(book); 
	}
	
	@PutMapping("/update/book")
	public Book updateBook(@Valid@RequestBody BookUpdateRequest bookUpdateRequest) {
		
		
		 return bookService.updateBook(bookUpdateRequest.to());
		
	}
	
	@DeleteMapping("/delete/book")
	public Book deleteBook(@RequestParam("id") int id) {
		return bookService.deleteBook(id);
	}
	
}
