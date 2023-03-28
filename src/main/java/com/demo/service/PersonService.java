package com.demo.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<Person> getAll(){
		return personRepo.findAll();
	}
	
	public String update(Person person, Long id) {
		Optional<Person> p = personRepo.findById(id);
		if(p.isEmpty()) {
			return "id not found";
		}
		Person pp = p.get();
		pp.setEmail(person.getEmail());
		pp.setName(person.getName());
		pp.setPassword(person.getPassword());
		personRepo.save(pp);
		return "Updated";
	}
	
	public String delete(Long id) {
		Optional<Person> p = personRepo.findById(id);
		if(p.isEmpty()) {
			return "id not found";
		}
		Person pp = p.get();
		personRepo.delete(pp);
		return "Deleted";
	}
	
}
