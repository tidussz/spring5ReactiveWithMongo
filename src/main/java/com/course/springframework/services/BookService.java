package com.course.springframework.services;

import com.course.springframework.persistance.model.Book;

import reactor.core.publisher.Flux;

public interface BookService extends CrudService<Book, String> {

	Flux<Book> findByAuthorId(String authorId);
}
