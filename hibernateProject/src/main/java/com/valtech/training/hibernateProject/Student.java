package com.valtech.training.hibernateProject;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Student {

	@Id
	private int rollNo;
	private String sName;
	private int sAge;
	
	@ManyToMany
	private Set<Laptop>laptops;
	
	
//	public List<Laptop> getLaptops() {
//		return laptops;
//	}
//	public void setLaptops(List<Laptop> laptops) {
//		this.laptops = laptops;
//	}
	public int getRollNo() {
		return rollNo;
	}
	public Set<Laptop> getLaptops() {
		return laptops;
	}
	public void setLaptops(Set<Laptop> laptops) {
		this.laptops = laptops;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsAge() {
		return sAge;
	}
	public void setsAge(int sAge) {
		this.sAge = sAge;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", sName=" + sName + ", sAge=" + sAge + "]";
	}
	
	
}
