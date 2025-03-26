package com.valtech.training.loanserverservice.services;

import java.util.Random;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.loanserverservice.VO.LoanVO;
import com.valtech.training.loanserverservice.entities.Loan;
import com.valtech.training.loanserverservice.repos.LoanRepo;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class LoanServicesImpl implements LoanService {

	@Autowired
	private LoanRepo loanRepo;

	
	@Override
	public Loan applyForLoan(Loan loan) {
	loan.applyForAndUpdateLoanStatus();
	return loanRepo.save(loan);
	}
	
	
	@Override
	public Loan ApproveLoan(long id) {
	
		Loan loan=loanRepo.getReferenceById(id);
		loan.approveAndUpdateLoanStatus();
		return loanRepo.save(loan);
		
	}
	
}
