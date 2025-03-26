package com.valtech.training.assignment1.VO;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.valtech.training.assignment1.entities.Adress;
import com.valtech.training.assignment1.entities.Customer;



public record CustomerVO(long id,String name,int age,String currentCity,int currentPinCode,String currentStreet,String permanantCity,int permanantPinCode,String permanantStreet,Set<Long>OrderIds ){
	
	
	
	
	
	
	
	public static  CustomerVO from(Customer c) {
		Set<Long> orderIds=c.getOrders().stream().map(w->w.getId()).collect(Collectors.toSet());
		return new CustomerVO(c.getId(),c.getName(),c.getAge(),c.getCurrentAdress().getCityName(),c.getCurrentAdress().getPinCode(),c.getCurrentAdress().getStreetName(),c.getPermanantAdress().getCityName(),c.getPermanantAdress().getPinCode(),c.getPermanantAdress().getStreetName(),orderIds);	
	}
	
	
	public Customer to() {
		Adress permanantAdress=new Adress(currentCity,currentPinCode,currentStreet);
		Adress currentAdress=new Adress(permanantCity,permanantPinCode,permanantStreet);
		
		return new Customer(id,name,age,currentAdress,permanantAdress);
		
	}


	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", name=" + name + ", age=" + age + ", currentCity=" + currentCity
				+ ", currentPinCode=" + currentPinCode + ", currentStreet=" + currentStreet + ", permanantCity="
				+ permanantCity + ", permanantPinCode=" + permanantPinCode + ", permanantStreet=" + permanantStreet
				+ ", OrderIds=" + OrderIds + "]";
	}

	
}
