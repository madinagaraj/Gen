package com.Genpact.Gen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Repository;
import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "Books")
public class Book {

	private long id;
	private String bookName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "LIBRARY_ID")
	private Library library;

	
	public Book() {
		
	}
	
	public Book(String bookName) {
		this.bookName = bookName;

	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "book_name", nullable = false)
	public String getbookName() {
		return bookName;
	}
	public void setbookName(String bookName) {
		this.bookName = bookName;
	}

	public Library getLibrary() {
		return library;
	}
	public void setLibrary(Library library) {
		this.library = library;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + "]";
	}
	
}
