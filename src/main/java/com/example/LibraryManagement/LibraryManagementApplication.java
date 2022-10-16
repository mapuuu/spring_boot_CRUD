package com.example.LibraryManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.LibraryManagement.entity.Book;
import com.example.LibraryManagement.repository.BookRepository;

@SpringBootApplication
public class LibraryManagementApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Book book1 = new Book("Mình về Hà Nội yêu nhau", "Minh Ngọc", "Đời thường");
//		bookRepository.save(book1);
		
	}

}
