package com.store.main.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.store.main.model.Books;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class BooksRepositoryTest {
	
	@Autowired
	private BooksRepository repo;
	
	@Test
	@Rollback(false)
	public void testCreateBooks() {
	    Books books = repo.save(new Books("1", "linux", "20", "punit", "2000", "20", "new"));
	     
	    assertThat(books.getID()).isEqualTo("1");
	}
	
	@Test
	@Rollback(false)
	public void testUpdateBooks() {
	    Books books = repo.save(new Books("1", "linux", "20", "punit", "2000", "20", "new"));
	     
	    assertThat(books.getID()).isEqualTo("1");
	}

}
