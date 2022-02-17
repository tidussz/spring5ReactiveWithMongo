package com.course.springframework.persistance.model;

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
@Document("book")
public class Book {

	@Id
	private String id;
	
	private String title;
	
	private Integer numOfPages;
	
	private Float price;

	@DBRef
	private Author author;
	
}
