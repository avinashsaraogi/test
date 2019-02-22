package com.assignment.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.boot.dao.BookRepository;
import com.assignment.boot.dao.SubjectRepository;
import com.assignment.boot.model.Subject;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Transactional
	public Subject saveSubject(Subject subject)
	{			
		subject=subjectRepository.save(subject);
		
		String bookRefsHib=subject.getBookId();
		if (!isBlank(bookRefsHib)) {
			String[] tmpBooks = (bookRefsHib.split(","));			
			for (int i = 0; i < tmpBooks.length; i++) {
				Long refBookId = (long) Integer.parseInt(tmpBooks[i]);
				bookRepository.updateSubjectId(subject.getSubjectId(),refBookId);
				
			}

		} 
		return subject;
	}
	public static boolean isBlank(String str) {
		int strLen;
		if (str != null && (strLen = str.length()) != 0) {
			for (int i = 0; i < strLen; ++i) {
				if (!Character.isWhitespace(str.charAt(i))) {
					return false;
				}
			}

			return true;
		} else {
			return true;
		}
	}
	@Transactional
	public Subject searchSubject(Long subjectId)
	{
				
		return subjectRepository.findById(subjectId).orElse(null);
	}
	
	@Transactional
	public void removeSubject(Long subjectId)
	{
				
		if(subjectId !=null)
		{			
			bookRepository.updateSubjectIdbyNull(subjectId);
		}
		subjectRepository.deleteById(subjectId);
	}
	@Transactional
	public String getSubjectId()
	{		
		String subjectIds="";
		List<Long> subjectIdList =subjectRepository.findSubjectIds();
		int count=0;
		for(Long subjectId :subjectIdList)
		{
			 if (count==0)
        	 {
        		 subjectIds = String.valueOf(subjectId);
        	 } else {
        		 subjectIds = subjectIds + ","+String.valueOf(subjectId);
        	 }
        	count++;
		}
		return subjectIds;
	}
	
	@Transactional
	public List<Subject> sortSubjectBySubTitile()
	{				
		return subjectRepository.findAllByOrderBySubtitle();
	} 
}
