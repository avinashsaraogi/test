package com.assignment.boot.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assignment.boot.model.Book;

public interface BookRepository extends ClientRepository<Book, Long> {
    
    List<Book> findAllByOrderByTitleAsc();
    List<Book> findAllByOrderByPublishDate();
    
  @Query("SELECT b.bookId FROM Book b ")
  	List<Long> findBookIds();
  
  
  @Modifying
  @Query("UPDATE Book b SET b.subjectId = :p1  where b.bookId = :p2 ")
	void updateSubjectId(@Param("p1") Long subjectId, @Param("p2") Long bookId);
  
  
  @Modifying
  @Query("UPDATE Book b SET b.subjectId = null  where b.subjectId = :p1 ")
	void updateSubjectIdbyNull(@Param("p1") Long subjectId);
  
  //@Query("SELECT b FROM Book b ORDER By b.title ")
	//List<Book> sortBookByTitle();
}

