package com.Genpact.Gen.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Genpact.Gen.exception.ResourceNotFoundException;
import com.Genpact.Gen.model.Book;
import com.Genpact.Gen.repository.BookRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class BookController {
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId)
			throws ResourceNotFoundException {
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));
		return ResponseEntity.ok().body(book);
	}

	@PostMapping("/books")
	public Book createBook(@Valid @RequestBody Book book) {
		return bookRepository.save(book);
	}

	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long bookId,
			@Valid @RequestBody Book bookDetails) throws ResourceNotFoundException {
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));


		book.setbookName(bookDetails.getbookName());

		final Book updatedBook = bookRepository.save(book);
		return ResponseEntity.ok(updatedBook);
	}


}
