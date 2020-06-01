package com.Genpact.Gen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.Genpact.Gen.model.Book;

public class SpringRestClient {

	private static final String GET_BOOKS_ENDPOINT_URL = "http://localhost:8080/api/v1/books";
	private static final String GET_BOOK_ENDPOINT_URL = "http://localhost:8080/api/v1/books/{id}";
	private static final String CREATE_BOOK_ENDPOINT_URL = "http://localhost:8080/api/v1/books";
	private static final String UPDATE_BOOK_ENDPOINT_URL = "http://localhost:8080/api/v1/books/{id}";

	private static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		SpringRestClient springRestClient = new SpringRestClient();
		
		// Step1: first create a new employee
		springRestClient.createBook();
		
		// Step 2: get new created employee from step1
		springRestClient.getBookById();
		
		// Step3: get all employees
		springRestClient.getBooks();
		
		// Step4: Update employee with id = 1
		springRestClient.updateBook();
		
	}

	private void getBooks() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(GET_BOOKS_ENDPOINT_URL, HttpMethod.GET, entity,
				String.class);

		System.out.println(result);
	}

	private void getBookById() {

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");

		RestTemplate restTemplate = new RestTemplate();
		Book result = restTemplate.getForObject(GET_BOOK_ENDPOINT_URL, Book.class, params);

		System.out.println(result);
	}

	private void createBook() {

		Book newBook = new Book("Book1");

		RestTemplate restTemplate = new RestTemplate();
		Book result = restTemplate.postForObject(CREATE_BOOK_ENDPOINT_URL, newBook, Book.class);

		System.out.println(result);
	}

	private void updateBook() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		Book updatedBook = new Book("admin123");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(UPDATE_BOOK_ENDPOINT_URL, updatedBook, params);
	}

}
