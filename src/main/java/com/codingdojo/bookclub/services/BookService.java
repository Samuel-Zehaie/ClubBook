package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;

	public BookService() {}

	public Book getOne(Long id){
	    Optional <Book> book = bookRepo.findById(id);
	    return book.isPresent() ? book.get() : null;
	}

	public List<Book> getAll() {
	    return(List<Book>) bookRepo.findAll();
	}

	public Book create(Book book) {
	    return bookRepo.save(book);
	}

	public Book update(Book book) {
	    return bookRepo.save(book);
	}

	public void delete(Long id){
	    bookRepo.deleteById(id);
	}
	
}
