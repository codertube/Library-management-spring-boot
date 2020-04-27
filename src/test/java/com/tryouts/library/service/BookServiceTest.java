/**
 * 
 */
package com.tryouts.library.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.tryouts.library.models.Book;
import com.tryouts.library.repository.BookRepository;

/**
 * @author ckarthi2
 *
 */
@RunWith(SpringRunner.class)
public class BookServiceTest {

	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public BookService bookService() {
            return new BookService();
        }
    }
 
    @Autowired
    private BookService bookService;
 
    @MockBean
    private BookRepository bookRepository;
    
    @Before
    public void setUp() {
        Book book = new Book("Secret Seven","Enid Blyton","Penguin");  
        Mockito.when(bookRepository.findByBookName(book.getBookName())).thenReturn(book);
    }
    
    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "alex";
        Book found = bookService.findByName(name);
        assertEquals(found.getBookName(),name);
     }
}
