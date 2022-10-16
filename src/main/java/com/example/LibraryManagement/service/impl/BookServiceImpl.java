package com.example.LibraryManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LibraryManagement.entity.Book;
import com.example.LibraryManagement.repository.BookRepository;
import com.example.LibraryManagement.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	private BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}


	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}


	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}


	@Override
	public Book getBookById(Integer bookcode) {
		return bookRepository.findById(bookcode).get();
	}


	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}


	@Override
	public void deleteBookById(Integer bookcode) {
		bookRepository.deleteById(bookcode);
	}

}
