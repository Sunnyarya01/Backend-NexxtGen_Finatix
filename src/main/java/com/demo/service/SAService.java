package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.SavingAccounts;
import com.demo.repo.SARepo;

@Service
public class SAService {

	@Autowired
	private SARepo repo;
	
	public SavingAccounts create(SavingAccounts accounts) {
		return repo.save(accounts);
	}
	
	public List<SavingAccounts> getAllAccounts(){
		return repo.findAll();
	}
	
	public String update(SavingAccounts accounts, Long id) {
		Optional<SavingAccounts> optional = repo.findById(id);
		if(optional.isEmpty()) {
			return "id not found";
		}else {
			SavingAccounts sa = optional.get();
			sa.setAbout(accounts.getAbout());
			sa.setEarn(accounts.getEarn());
			sa.setName(accounts.getName());
			repo.save(sa);
			return "Updated";
		}
	}
	
	public String delete(Long id) {
		Optional<SavingAccounts> optional = repo.findById(id);
		if(optional.isEmpty()) {
			return "id not found";
		}else {
			SavingAccounts sa = optional.get();
			repo.delete(sa);
			return "Deleted";
		}
	}
	
}
