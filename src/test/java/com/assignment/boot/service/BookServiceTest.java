package com.assignment.boot.service;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.assignment.boot.dao.BookRepository;
import com.assignment.boot.model.Book;

public class BookServiceTest {
	
	private static final long BOOK_ID = 5;
    private static final String TITLE = "TestBook";
    private static final double PRICE =100.0;
    private static final Integer VOLUME =new Integer(3);
    private static final LocalDate PUBLISH_DATE=(LocalDate.parse("2018/12/12",
            DateTimeFormatter.ofPattern("yyyy/MM/dd")));

	private BookRepository bookRepositoryMock;
	
	private BookServiceImpl bkService;
	
	@Before
    public void setUp() {
		bkService = new BookServiceImpl();

        bookRepositoryMock = mock(BookRepository.class);
        bkService.setBookRepository(bookRepositoryMock);
    }
	
	@Test
	public void saveBook() {

		Book book = new Book(TITLE, PRICE, VOLUME, PUBLISH_DATE, null);
		when(bookRepositoryMock.save(any(Book.class))).thenReturn(book);
		Book returned = bkService.saveBook(book);
		assertEquals(book, returned);
	}
	
	@Test
    public void searchBook_withResult() {
       
		Book[] books = new Book[2];
        Book book= new Book(TITLE,PRICE,VOLUME,PUBLISH_DATE,null);
       
        books[1]=book;
       
        Optional<Book> checkNull =  
                Optional.ofNullable(books[1]);
        
        when(bookRepositoryMock.findById(any(Long.class))).thenReturn(checkNull);
        
        Book returned = bkService.searchBook(new Long(1));

       // System.out.println("inside test cases"+returned);
        //System.out.println("inside test cases"+book);
      
        assertEquals(book, returned);
    }
	@Test
    public void searchBookWithoutResult() {
       
		Book[] books = new Book[2];
        //Book book= new Book(TITLE,PRICE,VOLUME,PUBLISH_DATE,null);
       // book.setBookId(1);
        //books[1]=book;
       
        Optional<Book> checkNull =  
                Optional.ofNullable(books[1]);
        
        when(bookRepositoryMock.findById(any(Long.class))).thenReturn(checkNull);
        
        Book returned = bkService.searchBook(new Long(1));

        System.out.println("inside test cases"+returned);
        
      
        assertEquals(null, returned);
    }
	
	@Test
    public void removeBook() {
		Long bookId=new Long(12);
		
       bkService.removeBook(bookId);
        System.out.println("inside test cases delete");
        
     // verify the mocks
        verify(bookRepositoryMock, times(1)).deleteById(eq(bookId));
      
        //assertEquals(book, book);
    }
	
	
	@Test
    public void getBookId() {
		
		String Source ="1,2,3";
		List<Long> bookIdList= new ArrayList<Long>(Arrays.asList(1L,2L,3L));
                       
        when(bookRepositoryMock.findBookIds()).thenReturn(bookIdList);
        
       String result=bkService.getBookId();
        
        
     //System.out.println("inside test cases"+result);
    
     assertEquals(Source, result);
    }
	@Test
    public void sortBookByTitle() {
		
		Book book= new Book(TITLE,PRICE,VOLUME,PUBLISH_DATE,null);
		//List<Long> bookIdList= new ArrayList<Long>(Arrays.asList(1L,2L,3L));
		List<Book> books =new ArrayList<Book>()  ;
		books.add(book);
        when(bookRepositoryMock.findAllByOrderByTitleAsc()).thenReturn(books);
        
        List<Book> results=bkService.sortBookByTitle();
             
        
     assertEquals(books, results);
    }
	@Test
    public void sortBookByTitle_withoutdata() {
		
		Book book= new Book(TITLE,PRICE,VOLUME,PUBLISH_DATE,null);
		//List<Long> bookIdList= new ArrayList<Long>(Arrays.asList(1L,2L,3L));
		List<Book> books =new ArrayList<Book>()  ;
		books.add(book);
        when(bookRepositoryMock.findAllByOrderByTitleAsc()).thenReturn(null);
        
        List<Book> results=bkService.sortBookByTitle();
            
     assertEquals(null, results);
    }
	@Test
    public void sortBookByPublishDate() {
		
		Book book= new Book(TITLE,PRICE,VOLUME,PUBLISH_DATE,null);
		//List<Long> bookIdList= new ArrayList<Long>(Arrays.asList(1L,2L,3L));
		List<Book> books =new ArrayList<Book>()  ;
		books.add(book);
        when(bookRepositoryMock.findAllByOrderByPublishDate()).thenReturn(books);
        
        List<Book> results=bkService.sortBookByPublishDate();
                   
     assertEquals(books, results);
    }
	@Test
    public void sortBookByPublishDateByNoResults() {
		
		Book book= new Book(TITLE,PRICE,VOLUME,PUBLISH_DATE,null);
		//List<Long> bookIdList= new ArrayList<Long>(Arrays.asList(1L,2L,3L));
		List<Book> books =new ArrayList<Book>()  ;
		books.add(book);
        when(bookRepositoryMock.findAllByOrderByPublishDate()).thenReturn(null);
        
        List<Book> results=bkService.sortBookByPublishDate();
        System.out.println("inside test cases delete"+results);         
        assertEquals(null, results);
        
    }
}
