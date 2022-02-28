package com.course.springframework.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CrudService<T, ID> {

	Flux<T> findAll();
	
	Mono<T> findById(ID id);
	
	Mono<T> save(T object);
	
	Mono<Void> delete(T object);
	
	Mono<Void> deleteById(ID id);
}
