package br.com.BookShelf.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.BookShelf.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	// Com essa anotação não é necesário fazer a conversão de iterable para List
	@Override
	List<Book> findAll();
	
}
