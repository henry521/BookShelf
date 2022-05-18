package br.com.BookShelf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import br.com.BookShelf.entity.Author;
import br.com.BookShelf.repository.AuthorRepository;

@Service
public class AuthorService {

	
	@Autowired
	private AuthorRepository authorRepository;
	
	public List<Author> getAuthorList(){
		Iterable<Author> authorIterable = this.authorRepository.findAll();
		return Streamable.of(authorIterable).toList();
	}
	
}
