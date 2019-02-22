package com.assignment.boot.service;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.assignment.boot.dao.BookRepository;
import com.assignment.boot.dao.SubjectRepository;
import com.assignment.boot.model.Book;
import com.assignment.boot.model.Subject;
@RunWith(MockitoJUnitRunner.class)
public class SubjectServiceTest {

	private static final long BOOK_ID = 5;
    private static final String TITLE = "TestBook";
    private static final double PRICE =100.0;
    private static final Integer VOLUME =new Integer(3);
    private static final LocalDate PUBLISH_DATE=(LocalDate.parse("2018/12/12",
            DateTimeFormatter.ofPattern("yyyy/MM/dd")));
    
    private static final int DURATION_IN_HOURS = 15;
    private static final String SUB_TITLE = "TestSubject";
    
    
    @Mock
	private SubjectRepository subjectRepositoryMock;
	
    @Mock
	private BookRepository bookRepositoryMock;
    
    @InjectMocks
    private SubjectServiceImpl subService;
    
    @Test
    public void saveSubject()
	{			
    	Book book = new Book(TITLE, PRICE, VOLUME, PUBLISH_DATE, null);
    	Set<Book> books = new HashSet<Book>();
    	Subject sourceSubject = new Subject(DURATION_IN_HOURS, SUB_TITLE, 2, books);
    	sourceSubject.setBookId("1");
    	Mockito.doNothing().when(bookRepositoryMock).updateSubjectId(any(Long.class),any(Long.class));
    	//Mockito.doThrow(new RuntimeException()).doNothing().when(bookRepositoryMock).updateSubjectId(any(Long.class),any(Long.class));
    	//when(bookRepositoryMock.updateSubjectId(any(Long.class),any(Long.class)));
    	when(subjectRepositoryMock.save(any(Subject.class))).thenReturn(sourceSubject);
    	Subject  returned = subService.saveSubject(sourceSubject);
    	   	
		assertEquals(sourceSubject, returned);	
	}
    @Test
    public void searchSubject() {
       
		Subject[] subjectCol = new Subject[2];
        
        Set<Book> books = new HashSet<Book>();
    	Subject sourceSubject = new Subject(DURATION_IN_HOURS, SUB_TITLE, 2, books);
    	subjectCol[1]=sourceSubject;
       
        Optional<Subject> checkNull =  
                Optional.ofNullable(subjectCol[1]);
        
        when(subjectRepositoryMock.findById(any(Long.class))).thenReturn(checkNull);
        
        Subject returned = subService.searchSubject(new Long(1));

        System.out.println("inside test cases"+returned);
        //System.out.println("inside test cases"+book);
      
        assertEquals(sourceSubject, returned);
    }
    
    @Test
    public void searchSubject_withoutResult() {
       
		Subject[] subjectCol = new Subject[2];
        
        Set<Book> books = new HashSet<Book>();
    	Subject sourceSubject = new Subject(DURATION_IN_HOURS, SUB_TITLE, 2, books);
    	//subjectCol[1]=sourceSubject;
       
        Optional<Subject> checkNull =  
                Optional.ofNullable(subjectCol[1]);
        
        when(subjectRepositoryMock.findById(any(Long.class))).thenReturn(checkNull);
        
        Subject returned = subService.searchSubject(new Long(1));

        System.out.println("inside test cases"+returned);
        //System.out.println("inside test cases"+book);
      
        assertEquals(null, returned);
    }
    
    @Test
    public void removeSubject() {
		Long subjectId=new Long(12);
		
		subService.removeSubject(subjectId);
        System.out.println("inside test cases delete");
        
     // verify the mocks
        verify(bookRepositoryMock, times(1)).updateSubjectIdbyNull(eq(subjectId));
        verify(subjectRepositoryMock, times(1)).deleteById(eq(subjectId));
      
        //assertEquals(book, book);
    }
    @Test
    public void getSubjectId() {
		
		String Source ="1,2,3";
		List<Long> subIdList= new ArrayList<Long>(Arrays.asList(1L,2L,3L));
                       
        when(subjectRepositoryMock.findSubjectIds()).thenReturn(subIdList);
        
       String result=subService.getSubjectId();
        
        
     //System.out.println("inside test cases"+result);
    
     assertEquals(Source, result);
    }
    @Test
    public void sortSubjectBySubTitile() {
		
    	Set<Book> books = new HashSet<Book>();
    	Subject sourceSubject = new Subject(DURATION_IN_HOURS, SUB_TITLE, 2, books);
		//List<Long> bookIdList= new ArrayList<Long>(Arrays.asList(1L,2L,3L));
		List<Subject> subjects =new ArrayList<Subject>()  ;
		subjects.add(sourceSubject);
        when(subjectRepositoryMock.findAllByOrderBySubtitle()).thenReturn(subjects);
        
        List<Subject> results=subService.sortSubjectBySubTitile();
             
        
     assertEquals(subjects, results);
    }
    @Test
    public void sortSubjectBySubTitile_without_data() {
		
    	Set<Book> books = new HashSet<Book>();
    	Subject sourceSubject = new Subject(DURATION_IN_HOURS, SUB_TITLE, 2, books);
		//List<Long> bookIdList= new ArrayList<Long>(Arrays.asList(1L,2L,3L));
		List<Subject> subjects =new ArrayList<Subject>()  ;
		subjects.add(sourceSubject);
        when(subjectRepositoryMock.findAllByOrderBySubtitle()).thenReturn(null);
        
        List<Subject> results=subService.sortSubjectBySubTitile();
             
        
     assertEquals(null, results);
    }
}
