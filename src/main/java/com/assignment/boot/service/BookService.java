package com.assignment.boot.service;

import java.util.List;

import com.assignment.boot.model.Book;

public interface BookService {

	public Book saveBook(Book book);
	public Book searchBook(Long bookId);
	public void removeBook(Long bookId);
	public String getBookId();
	public List<Book> sortBookByTitle();
	public List<Book> sortBookByPublishDate();
}
