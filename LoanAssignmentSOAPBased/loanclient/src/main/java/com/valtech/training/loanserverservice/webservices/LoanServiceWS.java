package com.valtech.training.loanserverservice.webservices;

import javax.jws.WebService;

import com.valtech.training.loanserverservice.entities.Loan;
import com.valtech.training.loanservice.VO.LoanVO;





@WebService
public interface LoanServiceWS {

	Loan applyLoan(Loan loanVo);
	
	Loan approveLoan(long id);
	
	
	
}
