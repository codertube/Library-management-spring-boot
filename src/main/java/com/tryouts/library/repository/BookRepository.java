/**
 * 
 */
package com.tryouts.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tryouts.library.models.Book;

/**
 * @author ckarthi2
 *
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	public Book findByBookName(String bookName);
}
