package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long>{
	
	

}
