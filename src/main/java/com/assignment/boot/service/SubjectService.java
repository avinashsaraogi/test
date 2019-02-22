package com.assignment.boot.service;

import java.util.List;

import com.assignment.boot.model.Subject;

public interface SubjectService {
	public Subject saveSubject(Subject subject);
	public Subject searchSubject(Long subjectId);
	public void removeSubject(Long subjectId);
	public String getSubjectId();
	public List<Subject> sortSubjectBySubTitile();
}
