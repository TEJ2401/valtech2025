package com.valtech.training.loanserverservice.webservices;

import javax.jws.WebService;

import com.valtech.training.loanserverservice.VO.LoanVO;
import com.valtech.training.loanserverservice.entities.Loan;
import com.valtech.training.loanserverservice.services.LoanService;




@WebService(endpointInterface = "com.valtech.training.loanserverservice.webservices.LoanServiceWS",serviceName = "LoanService",portName = "LoanServicePort")
public class LoanServiceWSImpl implements LoanServiceWS {

	private LoanService loanService;

	
	
	public LoanServiceWSImpl(LoanService loanService) {
		super();
		this.loanService = loanService;
	}
	
	
	@Override
	public Loan applyLoan(Loan loanVO) {
		
		return loanService.applyForLoan(loanVO);
	}
	
	
	@Override
	public Loan approveLoan(long id) {
		
		return loanService.ApproveLoan(id);
	}
}
