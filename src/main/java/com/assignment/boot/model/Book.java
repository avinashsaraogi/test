package com.assignment.boot.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "BOOK")
@Scope("prototype")
@Component("book")
public class Book {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6759420723286808179L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
	private long bookId;
	
	 @Column(name = "TITLE")
	private String title;
	 
	 @Column(name = "PRICE")
	private double price;
	 
	@Column(name = "VOLUME")
	private Integer volume;
	
	@Column(name = "PUBLISH_DATE")	
	private LocalDate publishDate;
	
	@Column(name = "SUBJECT_ID" , insertable = false)	
	private Long subjectId;
	
	@Transient
	private String inputDate;
	
	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	
	/*@ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name="SUBJECT_ID", updatable = true, nullable=true)
    private Subject subject;
	

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
*/
	public Book(String title, double price, Integer volume, LocalDate publishDate, Long subjectId) {
		super();
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishDate = publishDate;
		//this.subjectId = subjectId;
	}

	public Book() {
		super();
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	
	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price 
				+ " , volume=" + volume + ", publishDate=" + publishDate + ", subjectId=" + subjectId+ "]";
	}
	
	public void input(){
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Title: ");
		title = s.next();
		
		System.out.println("Enter Price: ");
		price = s.nextDouble();
		
		System.out.println("Enter Volume: ");
		volume = s.nextInt();
		
		System.out.println("Enter Date[yyyy/MM/dd]: ");
		publishDate = (LocalDate.parse(s.next(),
	            DateTimeFormatter.ofPattern("yyyy/MM/dd")));
		//Instant instant = ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		//publishDate= Date.from(instant);
		
		
	}
	
	
	
	
	
	
	

}
