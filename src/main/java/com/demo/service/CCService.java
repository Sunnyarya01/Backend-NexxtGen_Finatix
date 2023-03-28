package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.CreditCards;
import com.demo.repo.CCRepo;

@Service
public class CCService {
	
	@Autowired
	private CCRepo ccRepo;
	
	public CreditCards create(CreditCards cards) {
		return ccRepo.save(cards);
	}
	
	public List<CreditCards> getAllCards(){
		return ccRepo.findAll();
	}
	
	public String update(CreditCards cards, Long id) {
		Optional<CreditCards> creditCards = ccRepo.findById(id);
		if(creditCards.isEmpty()) {
			return "id not found";
		}else {
			CreditCards cc = creditCards.get();
			cc.setAbout(cards.getAbout());
			cc.setEarn(cards.getEarn());
			cc.setName(cards.getName());
			ccRepo.save(cc);
			return "Updated";
		}
	}
	
	public String delete(Long id) {
		Optional<CreditCards> creditCards = ccRepo.findById(id);
		if(creditCards.isEmpty()) {
			return "id not found";
		}else {
			CreditCards cc = creditCards.get();
			ccRepo.delete(cc);
			return "Deleted";
		}
	}

}
