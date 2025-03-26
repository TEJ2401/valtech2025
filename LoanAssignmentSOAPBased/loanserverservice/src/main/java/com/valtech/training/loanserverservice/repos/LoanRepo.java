package com.valtech.training.loanserverservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.valtech.training.loanserverservice.entities.Loan;



@Repository
public interface LoanRepo extends JpaRepository<Loan, Long> {

	
	
}
