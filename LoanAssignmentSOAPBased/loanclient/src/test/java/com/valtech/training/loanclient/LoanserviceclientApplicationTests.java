package com.valtech.training.loanclient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.loanserverservice.entities.Loan;
import com.valtech.training.loanserverservice.entities.Loan.LoanStatus;
import com.valtech.training.loanserverservice.entities.Loan.LoanType;
import com.valtech.training.loanserverservice.webservices.LoanServiceWS;



@SpringBootTest
class LoanserviceclientApplicationTests {

	@Autowired
	private LoanServiceWS loanServiceWS;
	
	
	@Test
	void applyAndApproveLoan() {
		
		System.out.println("HI");
		loanServiceWS.applyLoan(new Loan("ABC",LoanType.VEHICLE,750000,360001,360001,"Car",750000));
		loanServiceWS.approveLoan(1);
		

	}
	
	@Test
	void applyForLoan() {
		
		loanServiceWS.applyLoan(new Loan("CDE",LoanType.BUISNESS,5000000,36000001,4999999,"Car",400000));
		LoanStatus loanStatus= loanServiceWS.approveLoan(2).getLoanStatus();
		assertEquals(loanStatus.APPROVED,loanStatus);

	}
	
	
	

}
