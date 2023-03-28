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

import com.demo.model.SavingAccounts;
import com.demo.service.SAService;

@RestController("/saving_accounts")
@CrossOrigin(origins =  "*")
public class SA_Controller {
	
	@Autowired
	private SAService saService;
	
	@PostMapping("/")
	public SavingAccounts create(@RequestBody SavingAccounts accounts) {
		return saService.create(accounts);
	}
	
	@GetMapping("/")
	public List<SavingAccounts> get(@RequestBody SavingAccounts accounts) {
		return saService.getAllAccounts();
	}
	
	@PutMapping("/{id}")
	public String update(@RequestBody SavingAccounts accounts, @PathVariable("id") Long id) {
		return saService.update(accounts, id);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		return saService.delete(id);
	}

}
