package com.valtech.training.assignment1.VO;

import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.valtech.training.assignment1.entities.Customer;
import com.valtech.training.assignment1.entities.Item;
import com.valtech.training.assignment1.entities.LineItem;


public record LineItemVO(long itemId,int itemQuantity) {

	
	
	
	
	
	
	
	
//	public static LineItemVO from(LineItem ln) {
//		ItemVO itemVO=ItemVO.from(ln.getItem());
//		OrderVO orderVO=OrderVO.from(ln.getOrder());
//		return new LineItemVO(ln.getId(),itemVO,orderVO,ln.getOrderQuantity());
//	}
//	
//	public LineItem to() {
//		Item item=this.item.to();
//		
//		Orders order=this.order.to();
//		
//		return new LineItem(id,item,order,itemQuantity);
//	}
	
	
}
