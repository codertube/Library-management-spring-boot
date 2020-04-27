/**
 * 
 */
package com.tryouts.library.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.tryouts.library.controllers.BookController;
import com.tryouts.library.models.Book;
import com.tryouts.library.service.BookService;

/**
 * @author ckarthi2
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private BookService bookService;
    
    @Test
    public void givenBooks_whenGetBooks_thenReturnJsonArray()
      throws Exception {

    	Book books[] = new Book[2];
        books[0] = new Book("Secret Seven","Enid Blyton","Penguin");
        books[1] = new Book("Famous Five","Enid Blyton","Penguin");
     
        List<Book> bookList = Arrays.asList(books);
     
        //given(bookService.getBooks()).willReturn(bookList);
     
        mvc.perform(MockMvcRequestBuilders.get("/api/books")
          .accept(MediaType.APPLICATION_JSON))
          //.andExpect(status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
          .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(books[0]));
    }
}
