package br.com.BookShelf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "book")
@Entity(name = "book")
public class Book {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name ="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	public Book(String name,Author author) {
		this.name = name;
		this.author = author;
	}
	
}
