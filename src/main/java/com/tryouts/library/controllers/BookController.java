/**
 * 
 */
package com.tryouts.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tryouts.library.exception.ResourceNotFoundException;
import com.tryouts.library.models.Book;
import com.tryouts.library.service.BookService;

/**
 * @author ckarthi2
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getBooks() {
		return (List<Book>) bookService.getBooks();
	}

	@PostMapping("/books")
	void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}
	
	@PutMapping("/books/{id}")
    public Book updateBook(@PathVariable(value = "id") Long id, @RequestBody Book book) throws ResourceNotFoundException{
        return bookService.updateBook(id,book);
    }
}
