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
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.CreditCards;
import com.demo.service.CCService;

@RestController("Credit_Cards")
@CrossOrigin(origins = "*")
public class CC_Controller {

	@Autowired
	private CCService ccService;
	
	@PostMapping("/")
	public CreditCards create(@RequestBody CreditCards cards) {
		return ccService.create(cards);
	}
	
	@GetMapping("/")
	public List<CreditCards> get(@RequestBody CreditCards cards) {
		return ccService.getAllCards();
	}
	
	@PutMapping("/{id}")
	public String update(@RequestBody CreditCards cards, @PathVariable("id") Long id) {
		return ccService.update(cards, id);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		return ccService.delete(id);
	}
	
}
