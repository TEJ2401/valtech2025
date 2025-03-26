package com.valtech.training.assignment1.entities;

import java.util.HashSet;
import java.util.Set;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Customer {


	@Id@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "cust_seq")
	@SequenceGenerator(name = "cust_seq",sequenceName = "cust_seq",allocationSize = 1)
	private long id;
	
	
	private String name;
	
	private int age;
	
	@Embedded()
	@jakarta.persistence.AttributeOverrides(value = {@jakarta.persistence.AttributeOverride(name = "streetName",column = @jakarta.persistence.Column(name="current_street")),
			
	@jakarta.persistence.AttributeOverride(name="cityName",column = @jakarta.persistence.Column(name="current_City")),
	@jakarta.persistence.AttributeOverride(name="pinCode",column = @jakarta.persistence.Column(name="current_PinCode")),

	})
	private Adress currentAdress;
	
	
	
	@Embedded()
	@jakarta.persistence.AttributeOverrides(value = {@jakarta.persistence.AttributeOverride(name = "streetName",column = @jakarta.persistence.Column(name="permananat_Street")),
			
	@jakarta.persistence.AttributeOverride(name="cityName",column = @jakarta.persistence.Column(name="permanant_City")),
	@jakarta.persistence.AttributeOverride(name="pinCode",column = @jakarta.persistence.Column(name="permanant_PinCode")),

	})
	private Adress permanantAdress;
	
	
	public Adress getPermanantAdress() {
		return permanantAdress;
	}

	public void setPermanantAdress(Adress permanantAdress) {
		this.permanantAdress = permanantAdress;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(long id, String name, int age, Adress currentAdress,Adress permanantAdress) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.currentAdress = currentAdress;
		this.permanantAdress=permanantAdress;

	}
	
	
	
	@OneToMany(targetEntity = Orders.class, mappedBy="customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Orders> orders;
	
	public enum CustomerStatus{
		ENABLED,DISABLED
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Adress getCurrentAdress() {
		return currentAdress;
	}

	public void setCurrentAdress(Adress currentAdress) {
		this.currentAdress = currentAdress;
	}


	public Set<Orders> getOrders() {
		if(orders==null) orders=new HashSet<>();
		return orders;
	}

	public void AddOrders(Orders o) {
		Set<Orders>orders=getOrders();
		orders.add(o);
		
		
	}
	
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
	
	
}
