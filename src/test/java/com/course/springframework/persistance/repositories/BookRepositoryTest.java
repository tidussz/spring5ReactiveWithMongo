package com.course.springframework.persistance.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.course.springframework.persistance.model.Author;
import com.course.springframework.persistance.model.Book;

@DataMongoTest
class BookRepositoryTest {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	AuthorRepository authorRepository;

	@BeforeEach
	void setUp() throws Exception {
		Author author01 = new Author("1", "Stephen", "King", null);
		Author author02 = new Author("2", "Brandon", "Sanderson", null);
		
		Book book01 = new Book("1", "It", 1254, 19.99f, author01); 
		Book book02 = new Book("2", "The Shinning", 875, 9.99f, author01);
		Book book03 = new Book("3", "The Final Empire", 1105, 15.99F, author02); 
		Book book04 = new Book("4", "The Well of Ascension", 1585, 12.99F, author02); 
		Book book05 = new Book("5", "The Hero of Ages", 897, 24.99F, author02);

		authorRepository.save(author01);
		authorRepository.save(author02);
		
		bookRepository.save(book01);
		bookRepository.save(book02);
		bookRepository.save(book03);
		bookRepository.save(book04);
		bookRepository.save(book05);
	}

	@Test
	void testFindByAuthorId() {		
		
		Set<Book> book = bookRepository.findByAuthorId("1"); 
		
		assertEquals(2, book.size());
	}

}
