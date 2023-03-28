package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.SavingAccounts;

@Repository
public interface SARepo extends JpaRepository<SavingAccounts, Long>{

}
