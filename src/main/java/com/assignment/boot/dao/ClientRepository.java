package com.assignment.boot.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ClientRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {



}
