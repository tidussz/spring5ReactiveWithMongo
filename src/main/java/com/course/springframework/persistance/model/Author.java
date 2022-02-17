package com.course.springframework.persistance.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("author")
public class Author {

	@Id
	private String id;
	
	private String name;
	
	private String surname;
	
	@DBRef
	private Set<Book> books = new HashSet<>();
	
	public String getFullName() {
		return getSurname() + ", " + getName();
	}
}
