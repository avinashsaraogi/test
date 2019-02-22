package com.assignment.boot.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.assignment.boot.model.Book;
import com.assignment.boot.model.Subject;
import com.assignment.boot.service.BookService;
import com.assignment.boot.service.SubjectService;

@Controller
//@RequestMapping("/")
public class ClientController {

		
	@Autowired
	private BookService bookService;
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping({"","/index","/home"})	
	public String showHome() {		
		return "index";	}
	
	@PostMapping("/chooseOption")
	//@RequestMapping(value="/chooseOption", method = RequestMethod.POST)
	public ModelAndView ChooseOption(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String bookIds= null;
		String subjectIds= null;
		List<Book> searchlist ;
				
		ModelAndView modelAndView = new ModelAndView("index");
		int choice = Integer.parseInt(request.getParameter("option"));
		Book book = new Book();
		Subject subject = new Subject();
		switch (choice) {
		case 1:
						
			bookIds = bookService.getBookId();
			modelAndView = new ModelAndView("registerSubject");						
			modelAndView.addObject("subject", subject);
			modelAndView.addObject("bookIds", bookIds);
			
			break;
		case 2:
						
			modelAndView = new ModelAndView("registerBook");
			modelAndView.addObject("book", book);
			break;
		case 3:
			
			subjectIds = subjectService.getSubjectId();
			modelAndView = new ModelAndView("searchSubject");
			modelAndView.addObject("subject", subject);
			modelAndView.addObject("search", false);
			modelAndView.addObject("subjectIds", subjectIds);
			modelAndView.addObject("action", "deleteSubject.htm");
			break;
		case 4:
			
			bookIds = bookService.getBookId();
			modelAndView = new ModelAndView("searchBook");
			modelAndView.addObject("book", book);
			modelAndView.addObject("search", false);
			modelAndView.addObject("bookIds", bookIds);
			modelAndView.addObject("action", "deleteBook.htm");
			break;
		
		case 5:
			
			System.out.println("Search books" + book);
			bookIds = bookService.getBookId();
			modelAndView = new ModelAndView("searchBook");
			modelAndView.addObject("book", book);
			modelAndView.addObject("search", true);
			modelAndView.addObject("bookIds", bookIds);
			modelAndView.addObject("action", "searchBook.htm");
			break;
		case 6:
				
			subjectIds = subjectService.getSubjectId();
			modelAndView = new ModelAndView("searchSubject");
			modelAndView.addObject("subject", subject);
			modelAndView.addObject("search", true);
			modelAndView.addObject("subjectIds", subjectIds);
			modelAndView.addObject("action", "searchSubject.htm");
			
			break; 
		case 7:
			
								
			 searchlist = new ArrayList<Book>();									
			searchlist = bookService.sortBookByTitle();
			if (searchlist.isEmpty()) {
				System.out.println("There is no book to search");
				modelAndView.setViewName("saveBooks");
				modelAndView.addObject("greeting", "No Book has been found ");
			}
			else
			{				
				modelAndView.setViewName("searchBookDetails");
				modelAndView.addObject("searchBook", searchlist);
			}			
	        return modelAndView;
		case 8:
											
			 List<Subject> searchSublist = new ArrayList<Subject>();									
			 searchSublist = subjectService.sortSubjectBySubTitile();
			if (searchSublist.isEmpty()) {
				System.out.println("There is no book to search");
				modelAndView.setViewName("saveBooks");
				modelAndView.addObject("greeting", "No Subject has been found ");

			}
			else
			{
								
				modelAndView.setViewName("searchSubjectDetails");
				//modelAndView.addObject("searchSubject", searchSubject);
				modelAndView.addObject("searchSubject", searchSublist);
			}		
	        return modelAndView;
		case 9:
												
			 searchlist = new ArrayList<Book>();			
						
			searchlist = bookService.sortBookByPublishDate();
			if (searchlist.isEmpty()) {
				System.out.println("There is no book to search");
				modelAndView.setViewName("saveBooks");
				modelAndView.addObject("greeting", "No Book has been found ");
			}
			else
			{				
				modelAndView.setViewName("searchBookDetails");
				modelAndView.addObject("searchBook", searchlist);
			}			
	        return modelAndView;
		
		
		} 		
		
        return modelAndView;
    } 
	@PostMapping("/saveBooks.htm")	
	public ModelAndView saveBook(@ModelAttribute Book book) throws Exception {
				
		LocalDate publishDate = (LocalDate.parse(book.getInputDate(),
	            DateTimeFormatter.ofPattern("yyyy/MM/dd")));
		book.setPublishDate(publishDate);
		
		bookService.saveBook(book);
		ModelAndView modelAndView = new ModelAndView("saveBooks");
				
		modelAndView.addObject("greeting", "Book has been saved successfully");        
        return modelAndView;
    }
	@PostMapping("/saveSubject.htm")	
	//@RequestMapping(value="/saveSubject.htm", method = RequestMethod.POST)
	public ModelAndView saveSubject(@ModelAttribute Subject subject) throws Exception {
		
		subjectService.saveSubject(subject);
		ModelAndView modelAndView = new ModelAndView("saveBooks");					
		modelAndView.addObject("greeting", "Subject has been saved successfully");        
        return modelAndView;
    }
	@PostMapping("/searchBook.htm")	
	//@RequestMapping(value="/searchBook.htm", method = RequestMethod.POST)
	public ModelAndView searchBook(@ModelAttribute Book book) throws Exception {
		
		
		ArrayList<Book> searchlist = new ArrayList<Book>();
				
		ModelAndView modelAndView = new ModelAndView();
		
		Book searchBook = bookService.searchBook(book.getBookId());
		if (searchBook == null) {
			System.out.println("There is no book to search");
			modelAndView.setViewName("saveBooks");
			modelAndView.addObject("greeting", "No Book has been found ");

		}
		else
		{
			searchlist.add(searchBook);
			modelAndView.setViewName("searchBookDetails");
			modelAndView.addObject("searchBook", searchlist);
		}
		
        return modelAndView;
    }
	@PostMapping("searchSubject.htm")	
	//@RequestMapping(value="/searchSubject.htm", method = RequestMethod.POST)
	public ModelAndView searchSubject(@ModelAttribute Subject subject) throws Exception {
		
		ArrayList<Subject> searchlist = new ArrayList<Subject>();
				
		ModelAndView modelAndView = new ModelAndView();		
		Subject searchSubject = subjectService.searchSubject(subject.getSubjectId());
		
		if (searchSubject == null) {
			System.out.println("There is no book to search");
			modelAndView.setViewName("saveBooks");
			modelAndView.addObject("greeting", "No Subject has been found ");

		}
		else
		{			
			searchlist.add(searchSubject);
			modelAndView.setViewName("searchSubjectDetails");			
			modelAndView.addObject("searchSubject", searchlist);
		}		
        return modelAndView;
    }
	@PostMapping("deleteBook.htm")	
	//@RequestMapping(value="/deleteBook.htm", method = RequestMethod.POST)
	public ModelAndView deleteSubject(@ModelAttribute Book book) throws Exception {
		
		bookService.removeBook(book.getBookId());
		
		ModelAndView modelAndView = new ModelAndView("saveBooks");
		modelAndView.addObject("greeting", "Book has been Deleted successfully");        
        return modelAndView;
    }
	@PostMapping("deleteSubject.htm")	
	//@RequestMapping(value="/deleteSubject.htm", method = RequestMethod.POST)
	public ModelAndView deleteBook(@ModelAttribute Subject subject) throws Exception {
					
		subjectService.removeSubject(subject.getSubjectId());
		ModelAndView modelAndView = new ModelAndView("saveBooks");
		modelAndView.addObject("greeting", "Subject has been Deleted successfully");        
        return modelAndView;
    }
	
	
}
