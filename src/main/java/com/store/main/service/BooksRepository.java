package com.store.main.service;

import org.springframework.data.repository.CrudRepository;

import com.store.main.model.Books;

public interface BooksRepository extends CrudRepository<Books, String> {

}
