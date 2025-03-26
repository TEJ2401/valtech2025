package com.valtech.training.assignment1.VO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.valtech.training.assignment1.entities.Customer;
import com.valtech.training.assignment1.entities.LineItem;
import com.valtech.training.assignment1.entities.Orders;
import com.valtech.training.assignment1.entities.Orders.OrderStatus;


public class OrderVO {
	
	
	private long id;
	private OrderStatus orderStatus;
	private Set<LineItemVO> lineItems;
	private long customerId;
	
	
	
	
	public OrderVO(long id, OrderStatus orderStatus, Set<LineItemVO> lineItems, long customerId) {
		super();
		this.id = id;
		this.orderStatus = orderStatus;
		this.lineItems = lineItems;
		this.customerId = customerId;
	}
	
	
	public static OrderVO from(Orders o) {
		Set<LineItemVO>lineItemVO=o.getLineItems().stream().map(w->new LineItemVO(w.getItem().getId(),w.getOrderQuantity())).collect(Collectors.toSet());
		return new OrderVO(o.getId(),o.getOrderStatus(),lineItemVO,o.getCustomer().getId());
		
	}
	
	
	public Set<LineItemVO> getLineItems() {
		return lineItems;
	}


	public void setLineItems(Set<LineItemVO> lineItems) {
		this.lineItems = lineItems;
	}


	public Orders to() {
		
		
		Orders o=new Orders();
		o.setId(id);
		o.setOrderStatus(orderStatus);
		return o;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	
	
	
	
}
