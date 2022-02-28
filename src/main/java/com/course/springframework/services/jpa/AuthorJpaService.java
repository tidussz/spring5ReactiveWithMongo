package com.course.springframework.services.jpa;

import org.springframework.stereotype.Service;

import com.course.springframework.persistance.model.Author;
import com.course.springframework.persistance.repositories.AuthorRepository;
import com.course.springframework.services.AuthorService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AuthorJpaService implements AuthorService {
	
	private final AuthorRepository authorRepository;
	
	public AuthorJpaService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public Flux<Author> findAll() {
		return authorRepository.findAll();
	}

	@Override
	public Mono<Author> findById(String id) {
		return authorRepository.findById(id).or(null);
	}

	@Override
	public Mono<Author> save(Author object) {
		return authorRepository.save(object);
	}

	@Override
	public Mono<Void> delete(Author object) {
		return authorRepository.delete(object);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return authorRepository.deleteById(id);
	}
}
