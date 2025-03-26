package com.valtech.training.assignment1.entities;

import java.util.Set;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {

	@Id@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "ord_seq")
	@SequenceGenerator(name = "ord_seq",sequenceName = "ord_seq",allocationSize = 1)
	private long id;
	
	
	@OneToMany(mappedBy = "orders",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<LineItem>lineItems;
	
	@ManyToOne(targetEntity = Customer.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id",referencedColumnName = "id")
	private Customer customer;
	
	public enum OrderStatus{
		
		PENDING,PROCESSING,SHIPPED,DELIVERED
	}
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(long id, Set<LineItem> lineItems, Customer customer, OrderStatus orderStatus) {
		super();
		this.id = id;
		this.lineItems = lineItems;
		this.customer = customer;
		this.orderStatus = orderStatus;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Set<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	
	
	
	
	
}
