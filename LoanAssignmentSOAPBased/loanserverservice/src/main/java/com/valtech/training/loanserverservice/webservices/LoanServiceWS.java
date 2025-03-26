package com.valtech.training.loanserverservice.webservices;

import javax.jws.WebService;

import com.valtech.training.loanserverservice.VO.LoanVO;
import com.valtech.training.loanserverservice.entities.Loan;






@WebService
public interface LoanServiceWS {

	Loan applyLoan(Loan loanVo);
	
	Loan approveLoan(long id);
	
	
	
}
