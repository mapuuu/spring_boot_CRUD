package com.example.LibraryManagement.service;

import java.util.List;

import com.example.LibraryManagement.entity.Book;

public interface BookService {
	List<Book> getAllBooks();
	
	Book saveBook(Book book);
	
	Book getBookById(Integer bookcode);
	
	Book updateBook(Book book);
	
	void deleteBookById(Integer bookcode);
}
