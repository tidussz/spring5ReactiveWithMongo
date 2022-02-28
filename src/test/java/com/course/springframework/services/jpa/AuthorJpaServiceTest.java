package com.course.springframework.services.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.course.springframework.persistance.model.Author;
import com.course.springframework.persistance.repositories.AuthorRepository;
import com.course.springframework.services.AuthorService;

import reactor.core.publisher.Flux;

class AuthorJpaServiceTest {
	
	private AuthorService authorService;
	
	@Mock
	private AuthorRepository authorRepository;
	
	private AutoCloseable closeable;
	
	@BeforeEach
	public void initService() {
		closeable = MockitoAnnotations.openMocks(this);
		authorService = new AuthorJpaService(authorRepository);
	}
	
	@AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

	@Test
	void testFindAll() {
		Author author1 = new Author("12", "Name", "Surname", null); 
		Author author2 = new Author("13", "Name2", "Surname2", null); 
		Flux<Author> authors = Flux.just(author1, author2);
		
		when(authorRepository.findAll()).thenReturn(authors);
		
		Flux<Author> authorsFlux = authorService.findAll();
		assertEquals(authorsFlux, authors);
	}

}
