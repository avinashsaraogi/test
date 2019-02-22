package com.assignment.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.assignment.boot.model.Subject;

public interface SubjectRepository extends ClientRepository<Subject, Long>{

	@Query("SELECT s.subjectId FROM Subject s ")
  	List<Long> findSubjectIds();
	
	List<Subject> findAllByOrderBySubtitle();
}
