package com.course.springframework.services.jpa;

import org.springframework.stereotype.Service;

import com.course.springframework.persistance.model.Book;
import com.course.springframework.persistance.repositories.BookRepository;
import com.course.springframework.services.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookJpaService implements BookService {
	
	private final BookRepository bookRepository;
	
	public BookJpaService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Flux<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Mono<Book> findById(String id) {
		return bookRepository.findById(id).or(null);
	}

	@Override
	public Mono<Book> save(Book object) {
		return bookRepository.save(object);
	}

	@Override
	public Mono<Void> delete(Book object) {
		return bookRepository.delete(object);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return bookRepository.deleteById(id);
	}

	@Override
	public Flux<Book> findByAuthorId(String authorId) {
		return bookRepository.findByAuthorId(authorId);
	}
}
