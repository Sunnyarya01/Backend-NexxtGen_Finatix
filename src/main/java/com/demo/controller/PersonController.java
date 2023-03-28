package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Person;
import com.demo.service.PersonService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping("/")
	public Person register(@RequestBody Person person) {
		return personService.registerUser(person);
	}
	
	@GetMapping("/")
	public List<Person> get(){
		return personService.getAll();
	}
	
	@PutMapping("/{id}")
	public String update(@RequestBody Person person, @PathVariable("id") Long id) {
		return personService.update(person, id);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		return personService.delete(id); 
	}
	
}
