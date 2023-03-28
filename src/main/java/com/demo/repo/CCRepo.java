package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.CreditCards;

@Repository
public interface CCRepo extends JpaRepository<CreditCards, Long>{

}
