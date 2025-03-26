package com.valtech.training.loanserverservice.entities;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(name = "Loan")
public class Loan {
	
	
	@Id@GeneratedValue(generator = "loan_seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name = "loan_seq",sequenceName = "loan_seq",allocationSize = 1)
	private long id;
	
	
	public enum LoanType{
		
		VEHICLE,HOME,BUISNESS
	
	}
	
	public enum LoanStatus{
		APPLIED,APPROVED,REJECTED
	}
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private LoanType loanType;
	
	private int income;
	
	private int pan;
	
	private int aadhar;
	
	private int cibilScore;


	
	private int value;

	private String asset;
	
	
	
	@Enumerated(EnumType.STRING)
	private LoanStatus loanStatus;
	
	public LoanType getLoanType() {
		return loanType;
	}


	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}


	public LoanStatus getLoanStatus() {
		return loanStatus;
	}


	public void setLoanStatus(LoanStatus loanStatus) {
		this.loanStatus = loanStatus;
	}


	public Loan() {
		super();

	}



	public Loan(String name, LoanType loanType, int income, int pan, int aadhar, String asset, int value) {
		super();
		System.out.println("asset"+asset);
		this.name = name;
		this.loanType = loanType;
		this.income = income;
		this.pan = pan;
		this.aadhar = aadhar;
		this.asset = asset;
		this.value = value;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPan() {
		return pan;
	}

	public void setPan(int pan) {
		this.pan = pan;
	}

	public int getAadhar() {
		return aadhar;
	}

	public void setAadhar(int aadhar) {
		this.aadhar = aadhar;
	}

	public int getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}


	public int getIncome() {
		return income;
	}


	public void setIncome(int income) {
		this.income = income;
	}


	public void applyForAndUpdateLoanStatus() {
		System.out.println(income);
		System.out.println(asset);
		this.setCibilScore(new Random().nextInt(100,1000));
		this.setLoanStatus(LoanStatus.APPLIED);
	}
	

	public void approveAndUpdateLoanStatus() {
		if(cibilScore<=600) {
			this.setLoanStatus(LoanStatus.REJECTED);
		}
		else if(cibilScore>=600 && cibilScore<640) {
			if(income*3<0.75*value) {
				this.setLoanStatus(LoanStatus.REJECTED);
			}
			else {
				this.setLoanStatus(LoanStatus.APPROVED);
			}
		}
		
		else if(cibilScore>640) {
			if(income*5<0.75*value) {
				this.setLoanStatus(LoanStatus.REJECTED);
			}
			else {
				this.setLoanStatus(LoanStatus.APPROVED);
			}
		}
	}
	
	
	
	
	
}

