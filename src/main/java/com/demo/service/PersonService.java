package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Person;
import com.demo.repo.PersonRepo;

@Service
public class PersonService {

	@Autowired 
	private PersonRepo personRepo;
	
	public Person registerUser(Person person) {
		return personRepo.save(person);
	}
	
}
