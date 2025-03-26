package com.valtech.training.loanserverservice.services;


import com.valtech.training.loanserverservice.entities.Loan;

public interface LoanService {

	Loan applyForLoan(Loan loanVO);

	Loan ApproveLoan(long id);

}