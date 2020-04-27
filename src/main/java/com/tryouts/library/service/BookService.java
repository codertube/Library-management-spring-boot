/**
 * 
 */
package com.tryouts.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tryouts.library.exception.ResourceNotFoundException;
import com.tryouts.library.models.Book;
import com.tryouts.library.repository.BookRepository;

/**
 * @author ckarthi2
 *
 */
@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	 
    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }
 
    public void addBook(Book book) {
    	bookRepository.save(book);
    }
    
    public Book updateBook(Long bookID, Book bookDetails) throws ResourceNotFoundException{
    	Book book = bookRepository.findById(bookID).orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookID));
    	book.setBookName(bookDetails.getBookName());
    	book.setISBN(bookDetails.getISBN());
    	book.setAuthor(bookDetails.getAuthor());
    	book.setPublisher(bookDetails.getPublisher());
    	
    	final Book updatedBook = bookRepository.save(book);
    	return updatedBook;
    }
    
    public Book findByName(String name){
    	return bookRepository.findByBookName(name);
    }

}
