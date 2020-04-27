/**
 * 
 */
package com.tryouts.library.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import com.tryouts.library.models.Book;

/**
 * @author ckarthi2
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void whenFindByName_thenReturnBook() {
        // given
        Book book = new Book("Secret Seven","Enid Blyton","Penguin");
        entityManager.persist(book);
        entityManager.flush();
     
        // when
        Book found = bookRepository.findByBookName(book.getBookName());
     
        // then
        assertEquals(found.getBookName(),book.getBookName());
    }
}
