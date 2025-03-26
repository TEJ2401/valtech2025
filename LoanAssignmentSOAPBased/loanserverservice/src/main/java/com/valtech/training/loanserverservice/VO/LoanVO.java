package com.valtech.training.loanserverservice.VO;

import com.valtech.training.loanserverservice.entities.Loan;
import com.valtech.training.loanserverservice.entities.Loan.LoanStatus;
import com.valtech.training.loanserverservice.entities.Loan.LoanType;

public record LoanVO(long id,String name,LoanType loanType,int pan,int aadhar,int cibilScore,String asset,int value,LoanStatus loanStatus){
	
	public static LoanVO from(Loan loan) {
		
		return new LoanVO(loan.getId(),loan.getName(),loan.getLoanType(),loan.getPan(),loan.getAadhar(),loan.getCibilScore(),loan.getAsset(),loan.getValue(),loan.getLoanStatus());
	}
	
	
	public Loan to() {
		return new Loan(id,name,loanType,pan,aadhar,cibilScore,asset,value,loanStatus);
	}
	
	

}
