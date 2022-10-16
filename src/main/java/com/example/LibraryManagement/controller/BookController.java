package com.example.LibraryManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.LibraryManagement.entity.Book;
import com.example.LibraryManagement.service.BookService;

@Controller
public class BookController {
	
	private BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping("/books")
	public String listBooks(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "books";
	}
	
	@GetMapping("/books/new")
	public String createBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "create_book";
	}
	
	@PostMapping("/books")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookService.saveBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/books/edit/{id}")
	public String editBookForm(@PathVariable Integer id, Model model) {
		model.addAttribute("book", bookService.getBookById(id));
		return "edit_student";
	}
	
	@PostMapping("/books/{id}")
	public String updateBook(@PathVariable Integer id, @ModelAttribute("book") Book book, Model model) {
		
		//get book from db by bookcode
		Book existingBook = bookService.getBookById(id);
		existingBook.setBookcode(id);
		existingBook.setTitle(book.getTitle());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setCategory(book.getCategory());
		
		//update book obj
		bookService.updateBook(existingBook);
		return "redirect:/books";
	}
	
	//handler method to handle delete book req
	@GetMapping("/books/{id}")
	public String deleteBook(@PathVariable Integer id) {
		bookService.deleteBookById(id);
		return "redirect:/books";
	}
}
