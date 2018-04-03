package com.hotmart.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotmart.service.Document;

@Repository
public interface DocumentDao extends CrudRepository<Document, Long>{
	
	
}
