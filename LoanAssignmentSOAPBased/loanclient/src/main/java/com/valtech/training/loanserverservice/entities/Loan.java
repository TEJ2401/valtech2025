package com.valtech.training.loanserverservice.entities;

import java.util.Random;


public class Loan {


	private long id;
	
	public enum LoanType{
		
		VEHICLE,HOME,BUISNESS
	
	}
	
	public enum LoanStatus{
		APPLIED,APPROVED,REJECTED
	}
	
	private String name;
	
	private LoanType loanType;
	
	private int income;
	
	private int pan;
	
	private int aadhar;
	
	private int cibilScore;

	private String asset;
	
	private int value;

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

	
	public Loan(long id, String name,LoanType loanType, int pan, int aadhar, String asset, int value) {
		super();
		this.id = id;
		this.name = name;
		this.loanType=loanType;
		this.pan = pan;
		this.aadhar = aadhar;
		this.asset = asset;
		this.value = value;
	}

	public Loan(long id, String name, LoanType loanType, int pan, int aadhar, int cibilScore, String asset, int value,
			LoanStatus loanStatus) {
		super();
		this.id = id;
		this.name = name;
		this.loanType = loanType;
		this.pan = pan;
		this.aadhar = aadhar;
		this.cibilScore = cibilScore;
		this.asset = asset;
		this.value = value;
		this.loanStatus = loanStatus;
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
		asset = asset;
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

