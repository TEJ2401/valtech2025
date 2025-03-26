package com.valtech.training.loanclient;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.loanserverservice.entities.Loan;
import com.valtech.training.loanserverservice.entities.Loan.LoanStatus;
import com.valtech.training.loanserverservice.entities.Loan.LoanType;
import com.valtech.training.loanserverservice.webservices.LoanServiceWS;
import com.valtech.training.loanservice.VO.LoanVO;


@SpringBootTest
class LoanserviceclientApplicationTests {

	@Autowired
	private LoanServiceWS loanServiceWS;
	
	
	@Test
	void applyAndApproveLoan() {
		
		System.out.println("HI");
		loanServiceWS.applyLoan(new Loan(1,"ABC",LoanType.VEHICLE,360001,360001,0,"Car",750000,LoanStatus.APPLIED));
		
	}

}
