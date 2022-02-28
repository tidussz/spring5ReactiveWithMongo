package com.course.springframework.persistance.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.course.springframework.persistance.model.Book;

import reactor.core.publisher.Flux;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {
	
	Flux<Book> findByAuthorId(String authorId);
}
