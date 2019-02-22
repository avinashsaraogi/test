package com.assignment.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.boot.dao.BookRepository;
import com.assignment.boot.model.Book;

@Service("bookService")
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Transactional
	public Book saveBook(Book book)
	{				
		return bookRepository.save(book);
	}
	
	@Transactional
	public Book searchBook(Long bookId)
	{				
		
		return bookRepository.findById(bookId).orElse(null);
		
	}
	
	@Transactional
	public void removeBook(Long bookId)
	{		
		
		bookRepository.deleteById(bookId);
	}
	@Transactional
	public String getBookId()
	{		
		String bookIds="";
		List<Long> bookIdList =bookRepository.findBookIds();
		int count=0;
		for(Long bookid :bookIdList)
		{
			 if (count==0)
        	 {
        		 bookIds = String.valueOf(bookid);
        	 } else {
        		 bookIds = bookIds + ","+String.valueOf(bookid);
        	 }
        	count++;
		}
		return bookIds;
	}
	
	@Transactional
	public List<Book> sortBookByTitle()
	{
		
		List<Book> bk = bookRepository.findAllByOrderByTitleAsc();
		
		return bk;
	}
	@Transactional
	public List<Book> sortBookByPublishDate()
	{
				
		return  bookRepository.findAllByOrderByPublishDate();
	}
	
	/**
     * This setter method should be used only by unit tests.
     * @param bookRepository
     */
	protected void setBookRepository(BookRepository bookRepository)
	{
		this.bookRepository=bookRepository;
	}
}
