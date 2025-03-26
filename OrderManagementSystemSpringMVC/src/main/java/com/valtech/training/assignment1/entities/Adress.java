package com.valtech.training.assignment1.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Adress {

	private String cityName;
	private int pinCode;
	private String streetName;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public Adress(String cityName, int pinCode, String streetName) {
		super();
		this.cityName = cityName;
		this.pinCode = pinCode;
		this.streetName = streetName;
	}
	public Adress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
