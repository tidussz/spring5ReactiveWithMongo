package com.course.springframework.persistance.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.course.springframework.persistance.model.Author;

public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {
}
