package com.store.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.main.model.Books;

@Service
public class BooksService {
	
	@Autowired
	BooksRepository BooksRepository;
	
	public List<Books> getAllBooks(){
		List<Books> books = new ArrayList<>();
		BooksRepository.findAll()
		.forEach(books::add);
		
		return books;
		
	}
	
	public Optional<Books> getBook(String Id) {
		
		return BooksRepository.findById(Id);
	}
	
	public void addBooks(Books books) {
		BooksRepository.save(books);
	}
	
	public void deleteBooks(String Id) {
		BooksRepository.deleteById(Id);
	}
	
	public void updateBooks(Books book, String Id) {
		BooksRepository.save(book);
	}
	
	
}
