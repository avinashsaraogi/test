package com.assignment.boot.model;

import java.io.Serializable;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "SUBJECT")
@Scope("prototype")
@Component("subject")
public class Subject implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5183723877485964946L;
	
	
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBJECT_ID",  nullable = false)
	private long subjectId ;
	
	 @Column(name = "DURATION_IN_HOURS")
	private int durationInHours; // Gets executed for every constructor call
	 
	 @Column(name = "SUB_TITLE")
	private String subtitle;
	 
	 @Transient
	 //@OneToMany(mappedBy="subject")
	private Set<Book> books;// HAS-A relationship
	
	 @Transient
	 private String bookId ;
		
		public String getBookId() {
			return bookId;
		}


		public void setBookId(String bookId) {
			this.bookId = bookId;
		}
	public Subject(int durationInHours, String subtitle, long subjectId, Set<Book> books) {
		super();
		this.durationInHours = durationInHours;
		this.subtitle = subtitle;
		this.books = books;
	}


	public Subject() {
		super();
	}


	public int getDurationInHours() {
		return durationInHours;
	}


	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}


	public String getSubtitle() {
		return subtitle;
	}


	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}


	public long getSubjectId() {
		return subjectId;
	}

	@Transient
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}


	public Set<Book> getBooks() {
		return books;
	}


	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	public void displayBooks() {
	    for(Book b : books){
	            System.out.println(b);
	        }
	}
	
	@Override
	public String toString() {
		return "Subject [durationInHours=" + durationInHours + ", subtitle=" + subtitle + ", subjectId=" + subjectId + 
				", Books="+  books.toString()
				 + "]";
	}
	
	public void input(){
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Subtitle: ");
		subtitle = s.next();
			
		System.out.println("Enter Duration: ");
		durationInHours = s.nextInt();	
		
	}
	




	
	

	
	
	

	

	
	

}
