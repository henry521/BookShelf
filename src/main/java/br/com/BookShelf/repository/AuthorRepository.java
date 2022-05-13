package br.com.BookShelf.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.BookShelf.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}

